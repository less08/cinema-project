package com.dev.filarmonic.service;

import com.dev.filarmonic.model.ConcertSession;
import com.dev.filarmonic.model.ShoppingCart;
import com.dev.filarmonic.model.User;

public interface ShoppingCartService {
    void addSession(ConcertSession concertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
