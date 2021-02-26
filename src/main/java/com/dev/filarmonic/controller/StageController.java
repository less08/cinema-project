package com.dev.filarmonic.controller;

import com.dev.filarmonic.model.dto.StageRequestDto;
import com.dev.filarmonic.model.dto.StageResponseDto;
import com.dev.filarmonic.service.StageService;
import com.dev.filarmonic.service.mapper.StageMapper;
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
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final StageMapper mapper;

    @Autowired
    public StageController(StageService stageService, StageMapper mapper) {
        this.stageService = stageService;
        this.mapper = mapper;
    }

    @PostMapping
    public void addStage(@RequestBody @Valid StageRequestDto requestDto) {
        stageService.add(mapper.createEntityFromDto(requestDto));
    }

    @GetMapping
    public List<StageResponseDto> getAllStages() {
        return stageService.getAll().stream()
            .map(mapper::createDtoFromEntity)
            .collect(Collectors.toList());
    }
}
