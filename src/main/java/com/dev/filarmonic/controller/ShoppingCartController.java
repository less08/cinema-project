package com.dev.filarmonic.controller;

import com.dev.filarmonic.model.ConcertSession;
import com.dev.filarmonic.model.ShoppingCart;
import com.dev.filarmonic.model.User;
import com.dev.filarmonic.model.dto.ShoppingCartResponseDto;
import com.dev.filarmonic.service.ConcertSessionService;
import com.dev.filarmonic.service.ShoppingCartService;
import com.dev.filarmonic.service.UserService;
import com.dev.filarmonic.service.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper mapper;
    private final UserService userService;
    private final ConcertSessionService concertSessionService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper mapper, UserService userService,
                                  ConcertSessionService concertSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.mapper = mapper;
        this.userService = userService;
        this.concertSessionService = concertSessionService;
    }

    @PostMapping
    public void addConcertSession(Authentication auth, @RequestParam Long concertSessionId) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        User user = userService.findByEmail(email).get();
        ConcertSession concertSession = concertSessionService.getById(concertSessionId);
        shoppingCartService.addSession(concertSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String email = principal.getUsername();
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findByEmail(email).get());
        return mapper.createDtoFromEntity(shoppingCart);
    }
}
