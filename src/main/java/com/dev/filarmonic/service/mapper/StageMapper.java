package com.dev.filarmonic.service.mapper;

import com.dev.filarmonic.model.Stage;
import com.dev.filarmonic.model.dto.StageRequestDto;
import com.dev.filarmonic.model.dto.StageResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StageMapper {
    public StageResponseDto createDtoFromEntity(Stage stage) {
        StageResponseDto dto = new StageResponseDto();
        dto.setId(stage.getId());
        dto.setCapacity(stage.getCapacity());
        dto.setDescription(stage.getDescription());
        return dto;
    }

    public Stage createEntityFromDto(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setDescription(dto.getDescription());
        stage.setCapacity(dto.getCapacity());
        return stage;
    }
}
