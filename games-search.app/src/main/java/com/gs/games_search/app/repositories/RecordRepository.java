package com.gs.games_search.app.repositories;

import com.gs.games_search.app.domain.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    // Put coalesce after put postgres
    @Query("SELECT obj FROM Record obj WHERE " +
            "(:min IS NULL OR obj.moment >= :min) AND " +
            "(:max IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(Instant min, Instant max, PageRequest pageRequest);
}
