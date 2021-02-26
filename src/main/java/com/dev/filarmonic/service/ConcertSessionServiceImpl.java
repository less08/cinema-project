package com.dev.filarmonic.service;

import com.dev.filarmonic.dao.ConcertSessionDao;
import com.dev.filarmonic.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    @Autowired
    public ConcertSessionServiceImpl(ConcertSessionDao concertSessionDao) {
        this.concertSessionDao = concertSessionDao;
    }

    @Override
    public ConcertSession add(ConcertSession session) {
        return concertSessionDao.add(session);
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(concertId, date);
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        return concertSessionDao.update(concertSession);
    }

    @Override
    public void delete(Long id) {
        concertSessionDao.delete(id);
    }

    @Override
    public ConcertSession getById(Long id) {
        return concertSessionDao.getById(id).get();
    }
}
