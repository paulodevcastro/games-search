package com.gs.games_search.app.repositories;

import com.gs.games_search.app.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
