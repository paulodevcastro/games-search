package com.gs.games_search.app.dtos;

import com.gs.games_search.app.domain.Game;
import com.gs.games_search.app.domain.enums.Platform;

public record GameDto(
        Long id,
        String title,
        Platform platform
) {
    public GameDto(Game entity){
        this(entity.getId(), entity.getTitle(), entity.getPlatform());
    }
}
