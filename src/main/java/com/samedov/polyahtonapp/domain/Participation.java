package com.samedov.polyahtonapp.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

// Список соревнований (с результатами), в которых принимал участие спортсмен
@Entity
@Table
@EqualsAndHashCode(of = {"id"})
public class Participation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "sportsman_id", nullable = false)
    private Sportsman sportsman;

    // 4-борье, 5-борье и тд
    private String type;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }
}
