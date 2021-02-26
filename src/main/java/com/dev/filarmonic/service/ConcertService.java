package com.dev.filarmonic.service;

import com.dev.filarmonic.model.Concert;
import java.util.List;

public interface ConcertService {
    Concert add(Concert concert);

    List<Concert> getAll();

    Concert getById(Long id);
}
