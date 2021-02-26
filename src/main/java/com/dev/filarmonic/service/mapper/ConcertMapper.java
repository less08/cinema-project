package com.dev.filarmonic.service.mapper;

import com.dev.filarmonic.model.Concert;
import com.dev.filarmonic.model.dto.ConcertRequestDto;
import com.dev.filarmonic.model.dto.ConcertResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper {

    public ConcertResponseDto createDtoFromEntity(Concert concert) {
        ConcertResponseDto dto = new ConcertResponseDto();
        dto.setId(concert.getId());
        dto.setDescription(concert.getDescription());
        dto.setTitle(concert.getTitle());
        return dto;
    }

    public Concert createEntityFromDto(ConcertRequestDto dto) {
        Concert concert = new Concert();
        concert.setDescription(dto.getDescription());
        concert.setTitle(dto.getTitle());
        return concert;
    }
}
