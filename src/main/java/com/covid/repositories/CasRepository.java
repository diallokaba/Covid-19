package com.covid.repositories;

import com.covid.entities.Cas;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
// ou @Component
public interface CasRepository extends JpaRepository<Cas, Long> {

    @Query("select c from Cas c where c.ville=:ville")
    public List<Cas> getAllCasByVille(@Param("ville") String ville);

    @Query("select c from Cas c where c.quartier=:quartier")
    public List<Cas> getAllCasByQuartier(@Param("quartier") String quartier);

    @Query("select c from Cas c where c.id =:id")
    public Cas getById(@Param("id") Long id);
}
