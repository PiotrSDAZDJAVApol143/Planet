package org.example.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class PlanetDataEntity {
    private Long id;
    private String englishName;
    private boolean isPlanet;
    private PlanetParameters parameters;

    public PlanetDataEntity(Long id, String englishName, boolean isPlanet, PlanetParameters parameters) {
        this.id = id;
        this.englishName = englishName;
        this.isPlanet = isPlanet;
        this.parameters = parameters;
    }

    public PlanetDataEntity(Long id, String englishName, boolean isPlanet) {
        this.id = id;
        this.englishName = englishName;
        this.isPlanet = isPlanet;
    }

    public PlanetDataEntity(){

    }

    @Override
    public String toString() {
        return "PlanetDataEntity{" +
                "id=" + id +
                ", englishName='" + englishName + '\'' +
                ", isPlanet=" + isPlanet +
                ", parameters=" + parameters +
                '}';
    }
}

