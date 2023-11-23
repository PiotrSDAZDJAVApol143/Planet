package api.le_systeme_solarie;

import com.google.gson.JsonElement;
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
}
