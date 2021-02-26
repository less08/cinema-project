package com.dev.filarmonic.controller;

import com.dev.filarmonic.model.ConcertSession;
import com.dev.filarmonic.model.dto.ConcertSessionRequestDto;
import com.dev.filarmonic.model.dto.ConcertSessionResponseDto;
import com.dev.filarmonic.service.ConcertSessionService;
import com.dev.filarmonic.service.mapper.ConcertSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concert-sessions")
public class ConcertSessionController {
    private final ConcertSessionService concertSessionService;
    private final ConcertSessionMapper mapper;

    @Autowired
    public ConcertSessionController(ConcertSessionService concertSessionService,
                                    ConcertSessionMapper mapper) {
        this.concertSessionService = concertSessionService;
        this.mapper = mapper;
    }

    @PostMapping
    public void addConcertSession(@RequestBody @Valid ConcertSessionRequestDto requestDto) {
        concertSessionService.add(mapper.createEntityFromDto(requestDto));
    }

    @GetMapping("/available")
    public List<ConcertSessionResponseDto> getAvailableSessions(
                @RequestParam Long concertId, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
                LocalDate date) {
        return concertSessionService.findAvailableSessions(concertId, date)
            .stream().map(mapper::createDtoFromEntity)
            .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateConcertSession(@RequestBody @Valid ConcertSessionRequestDto requestDto,
                                   @PathVariable Long id) {
        ConcertSession concertSession = mapper.createEntityFromDto(requestDto);
        concertSession.setId(id);
        concertSessionService.update(concertSession);
    }

    @DeleteMapping("/{id}")
    public void deleteConcertSession(@PathVariable Long id) {
        concertSessionService.delete(id);
    }
}
