package com.dev.filarmonic.service.mapper;

import com.dev.filarmonic.model.ShoppingCart;
import com.dev.filarmonic.model.Ticket;
import com.dev.filarmonic.model.dto.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto createDtoFromEntity(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        dto.setUserEmail(shoppingCart.getUser().getEmail());
        dto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
