package com.dev.cinema.controller;

import com.dev.cinema.model.dto.CinemaHallRequestDto;
import com.dev.cinema.model.dto.CinemaHallResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper mapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto requestDto) {
        cinemaHallService.add(mapper.createEntityFromDto(requestDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
            .map(mapper::createDtoFromEntity)
            .collect(Collectors.toList());
    }
}
