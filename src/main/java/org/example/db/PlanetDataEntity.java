package org.example.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlanetDataEntity {
    private Long id;
    private String englishName;
    private boolean isPlanet;
    private PlanetParameters parameters;

}

