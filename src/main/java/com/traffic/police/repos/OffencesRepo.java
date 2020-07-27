package com.traffic.police.repos;

import com.traffic.police.models.OffencesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OffencesRepo extends JpaRepository<OffencesEntity, Long> {

    @Query("select a from OffencesEntity  a where a.offenceid=:offenceid")
    OffencesEntity findByOffenceid(@Param("offenceid") int offenceid );
}
