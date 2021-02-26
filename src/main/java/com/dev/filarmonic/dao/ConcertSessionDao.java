package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConcertSessionDao {
    ConcertSession add(ConcertSession concertSession);

    List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);

    Optional<ConcertSession> getById(Long id);
}
