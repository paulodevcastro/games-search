package com.gs.games_search.app.services;

import com.gs.games_search.app.domain.Game;
import com.gs.games_search.app.dtos.GameDto;
import com.gs.games_search.app.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDto> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameDto::new).collect(Collectors.toList());
    }

}
