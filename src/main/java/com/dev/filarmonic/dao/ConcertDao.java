package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.Concert;
import java.util.List;
import java.util.Optional;

public interface ConcertDao {
    Concert add(Concert concert);

    List<Concert> getAll();

    Optional<Concert> getById(Long id);
}
