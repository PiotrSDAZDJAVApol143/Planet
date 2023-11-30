package org.example.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString


public class PlanetDataEntity {
    private Long id;
    private String englishName;
    private String bodyType;
    private PlanetParameters parameters;



}

