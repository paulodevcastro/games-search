package com.gs.games_search.app.repositories;

import com.gs.games_search.app.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
