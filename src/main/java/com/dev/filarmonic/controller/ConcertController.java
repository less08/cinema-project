package com.dev.filarmonic.controller;

import com.dev.filarmonic.model.dto.ConcertRequestDto;
import com.dev.filarmonic.model.dto.ConcertResponseDto;
import com.dev.filarmonic.service.ConcertService;
import com.dev.filarmonic.service.mapper.ConcertMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper mapper;

    @Autowired
    public ConcertController(ConcertService concertService, ConcertMapper mapper) {
        this.concertService = concertService;
        this.mapper = mapper;
    }

    @PostMapping
    public void addConcert(@RequestBody @Valid ConcertRequestDto requestDto) {
        concertService.add(mapper.createEntityFromDto(requestDto));
    }

    @GetMapping
    public List<ConcertResponseDto> getAllConcerts() {
        return concertService.getAll().stream()
            .map(mapper::createDtoFromEntity)
            .collect(Collectors.toList());
    }
}
