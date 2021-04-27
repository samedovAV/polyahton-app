package com.samedov.polyahtonapp.controller;

import com.samedov.polyahtonapp.domain.Sportsman;
import com.samedov.polyahtonapp.domain.Views;
import com.samedov.polyahtonapp.dto.EventType;
import com.samedov.polyahtonapp.dto.ObjectType;
import com.samedov.polyahtonapp.repository.SportmanRepository;
import com.samedov.polyahtonapp.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("/sportsman")
public class SportsmanController {

    private final SportmanRepository sportmanRepository;
    private final BiConsumer<EventType, Sportsman> wsSender;

    @Autowired
    public SportsmanController(SportmanRepository sportmanRepository, WsSender wsSender) {
        this.sportmanRepository = sportmanRepository;
        this.wsSender = wsSender.getSender(ObjectType.SPORTSMAN, Views.IdName.class);
    }

    @GetMapping
    public List<Sportsman> list() {
        return sportmanRepository.findAll();
    }

    @GetMapping("{id}")
    public Sportsman getOneSportsman(@PathVariable("id") Sportsman sportsman) {
        return sportsman;
    }

    @PostMapping
    public Sportsman addSportsman(@RequestBody Sportsman sportsman) {
        sportsman.setCreationDate(LocalDateTime.now());
        Sportsman updatedSportsman = sportmanRepository.save(sportsman);

        wsSender.accept(EventType.CREATE, updatedSportsman);

        return updatedSportsman;
    }

    @PutMapping("{id}")
    public Sportsman updateSportsman(
            @PathVariable("id") Sportsman sportsmanFromDB,
            @RequestBody Sportsman sportsman) {
        BeanUtils.copyProperties(sportsman, sportsmanFromDB, "id");
        Sportsman updatedSportsman =  sportmanRepository.save(sportsmanFromDB);

        wsSender.accept(EventType.UPDATE, updatedSportsman);

        return updatedSportsman;
    }

    @DeleteMapping("{id}")
    public void deleteSportsman(@PathVariable("id") Sportsman sportsman) {
        sportmanRepository.delete(sportsman);
        wsSender.accept(EventType.REMOVE, sportsman);
    }
}
