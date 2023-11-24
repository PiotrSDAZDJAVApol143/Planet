package org.example.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.api.le_systeme_solarie.Moon;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlanetParameters {
    private String id;
    private String englishName;
    private Double semimajorAxis;
    private Moon[] moons;
    private Double  gravity;
    private Double meanRadius;


}
