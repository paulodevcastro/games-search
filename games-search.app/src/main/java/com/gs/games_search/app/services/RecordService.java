package com.gs.games_search.app.services;

import com.gs.games_search.app.domain.Game;
import com.gs.games_search.app.domain.Record;
import com.gs.games_search.app.dtos.RecordDto;
import com.gs.games_search.app.dtos.RecordInsertDto;
import com.gs.games_search.app.repositories.GameRepository;
import com.gs.games_search.app.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDto insert(RecordInsertDto dto){
        Record rec = new Record();
        rec.setName(dto.name());
        rec.setAge(dto.age());
        rec.setMoment(Instant.now());
        rec.setGame(gameRepository.getReferenceById(dto.gameId()));

        return new RecordDto(recordRepository.save(rec));
    }
}
