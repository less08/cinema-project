package com.dev.filarmonic.service;

import com.dev.filarmonic.model.Stage;
import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage getById(Long id);
}
