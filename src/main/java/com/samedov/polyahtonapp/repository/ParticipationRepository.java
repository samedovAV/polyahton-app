package com.samedov.polyahtonapp.repository;

import com.samedov.polyahtonapp.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
