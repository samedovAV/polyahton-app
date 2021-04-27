package com.samedov.polyahtonapp.service;

import com.samedov.polyahtonapp.domain.Participation;
import com.samedov.polyahtonapp.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService {

    private final ParticipationRepository participationRepository;

    @Autowired
    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation create(Participation participation) {
        participationRepository.save(participation);

        return participation;
    }
}
