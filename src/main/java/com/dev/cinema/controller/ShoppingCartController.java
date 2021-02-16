package com.dev.cinema.controller;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.ShoppingCartResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final MovieSessionService movieSessionService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper mapper, UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.mapper = mapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return mapper.createDtoFromEntity(shoppingCartService.getByUser(userService
            .getById(userId)));
    }
}
