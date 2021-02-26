package com.dev.filarmonic.service.mapper;

import com.dev.filarmonic.model.ConcertSession;
import com.dev.filarmonic.model.dto.ConcertSessionRequestDto;
import com.dev.filarmonic.model.dto.ConcertSessionResponseDto;
import com.dev.filarmonic.service.ConcertService;
import com.dev.filarmonic.service.StageService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcertSessionMapper {
    private ConcertService concertService;
    private StageService stageService;

    @Autowired
    public ConcertSessionMapper(ConcertService concertService, StageService stageService) {
        this.concertService = concertService;
        this.stageService = stageService;
    }

    public ConcertSessionResponseDto createDtoFromEntity(ConcertSession concertSession) {
        ConcertSessionResponseDto dto = new ConcertSessionResponseDto();
        dto.setConcertSessionId(concertSession.getId());
        dto.setStageId(concertSession.getStage().getId());
        dto.setConcertTitle(concertSession.getConcert().getTitle());
        dto.setShowTime(concertSession.getShowTime().toString());
        return dto;
    }

    public ConcertSession createEntityFromDto(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setConcert(concertService.getById(dto.getConcertId()));
        concertSession.setStage(stageService.getById(dto.getStageId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return concertSession;
    }
}
