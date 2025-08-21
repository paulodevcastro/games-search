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

    // JPQL to consult data for records
    @Query("SELECT obj FROM Record obj WHERE " +
            /*coalesce -> */"(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND " +
            "(coalesce(:max,null) IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(Instant min, Instant max, PageRequest pageRequest);
}
