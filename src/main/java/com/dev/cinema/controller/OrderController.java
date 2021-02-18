package com.dev.cinema.controller;

import com.dev.cinema.model.dto.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper mapper,
                           UserService userService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public void completeOrder(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        orderService.completeOrder(shoppingCartService.getByUser(userService
                .findByEmail(email).get()));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersByUserId(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        return orderService.getOrdersHistory(userService.findByEmail(email).get())
            .stream()
            .map(mapper::createDtoFromEntity)
            .collect(Collectors.toList());
    }
}
