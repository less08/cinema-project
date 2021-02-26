package com.dev.filarmonic.service;

import com.dev.filarmonic.dao.ConcertDao;
import com.dev.filarmonic.model.Concert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    @Autowired
    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }

    @Override
    public Concert getById(Long id) {
        return concertDao.getById(id).get();
    }
}
