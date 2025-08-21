package com.gs.games_search.app.controllers;

import com.gs.games_search.app.dtos.RecordDto;
import com.gs.games_search.app.dtos.RecordInsertDto;
import com.gs.games_search.app.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<Page<RecordDto>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction){

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0){
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<RecordDto> recordDtos = recordService.findByMoments(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(recordDtos);
    }

}
