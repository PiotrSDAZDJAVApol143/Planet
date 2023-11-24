package org.example.api.le_systeme_solarie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SolarSystemPlanetDetailsResponse {
    private String id;
    private String englishName;
    private boolean isPlanet;
    private Moon[] moons;
    private Double  gravity;
    private String discoveredBy;
    private Double semimajorAxis;
    private Double meanRadius;

    //TODO: Tu ewentualnie można dodać jakieś nowe informacje i zastanowić się dlaczego discoveredBy - nie działa...
    public Integer getNumericId() {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
