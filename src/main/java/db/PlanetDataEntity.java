package db;

import api.le_systeme_solarie.Moon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetDataEntity {
    private Long id; // zmieniłem ze String na Long
    private String englishName;
    private boolean isPlanet;
    private PlanetParameters parameters;

}
