package db;

import api.le_systeme_solarie.Moon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetDataEntity {
    private String id;
    private String englishName;
    private boolean isPlanet;
    private PlanetParameters parameters;

    public Integer getNumericId() {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
