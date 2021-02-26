package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.ShoppingCart;
import com.dev.filarmonic.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
