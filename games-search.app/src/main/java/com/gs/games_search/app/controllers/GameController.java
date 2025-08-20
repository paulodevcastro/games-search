package com.gs.games_search.app.controllers;

import com.gs.games_search.app.domain.Game;
import com.gs.games_search.app.dtos.GameDto;
import com.gs.games_search.app.repositories.GameRepository;
import com.gs.games_search.app.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDto>> findAll(){
        List<GameDto> gamesDto = gameService.findAll();
        return ResponseEntity.ok().body(gamesDto);
    }

}
