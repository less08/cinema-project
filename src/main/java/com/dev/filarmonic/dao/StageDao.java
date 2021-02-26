package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.Stage;
import java.util.List;
import java.util.Optional;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Optional<Stage> getById(Long id);
}
