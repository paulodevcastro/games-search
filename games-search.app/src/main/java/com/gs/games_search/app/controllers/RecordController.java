package com.gs.games_search.app.controllers;

import com.gs.games_search.app.dtos.RecordDto;
import com.gs.games_search.app.dtos.RecordInsertDto;
import com.gs.games_search.app.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDto> insert(@RequestBody RecordInsertDto dto){
        RecordDto newDto = recordService.insert(dto);
        return ResponseEntity.ok().body(newDto);
    }

}
