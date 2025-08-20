package com.gs.games_search.app.dtos;

import com.gs.games_search.app.domain.Record;
import com.gs.games_search.app.domain.enums.Platform;

import java.time.Instant;

public record RecordDto(
        Long id,
        Instant moment,
        String name,
        Integer age,
        String gameTitle,
        Platform gamePlatform,
        String genreGame
) {
    public RecordDto(Record entity){
        this(entity.getId()
                ,entity.getMoment()
                ,entity.getName()
                ,entity.getAge()
                ,entity.getGame().getTitle()
                ,entity.getGame().getPlatform()
                ,entity.getGame().getGenre().getName()
                );
    }
}
