package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.OrderResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponseDto createDtoFromEntity(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate().toString());
        dto.setTicketIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setUserEmail(order.getUser().getEmail());
        return dto;
    }
}
