package com.dev.filarmonic.service;

import com.dev.filarmonic.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;

public interface ConcertSessionService {
    ConcertSession add(ConcertSession session);

    List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);

    ConcertSession getById(Long id);
}
