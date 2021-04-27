package com.samedov.polyahtonapp.repository;

import com.samedov.polyahtonapp.domain.Sportsman;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportmanRepository extends JpaRepository<Sportsman, Long> {

    @EntityGraph(attributePaths = { "participationList" })
    List<Sportsman> findAll();
}
