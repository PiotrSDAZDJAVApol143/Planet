package org.example.api.le_systeme_solarie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
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
    public Long getNumericId() {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
