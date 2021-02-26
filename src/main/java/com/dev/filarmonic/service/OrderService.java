package com.dev.filarmonic.service;

import com.dev.filarmonic.model.Order;
import com.dev.filarmonic.model.ShoppingCart;
import com.dev.filarmonic.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
