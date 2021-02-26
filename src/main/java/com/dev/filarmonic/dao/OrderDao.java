package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.Order;
import com.dev.filarmonic.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
