package org.example.handlers;

import lombok.AllArgsConstructor;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.handlers.math.DataClarityConverter;

import static org.example.handlers.math.DistanceFormatter.formatDistance;
import static org.example.handlers.math.TemperatureConverter.kelvinToCelsius;
@AllArgsConstructor
public class PlanetHandler {
    private final SolarSystemPlanetDetailsResponse solarSystemDetails;

    public void handle() {
        String moonsList = DataClarityConverter.convertMoonsList(solarSystemDetails.getMoons());

        String message = """
                    ------------------------------
                    Planet details :
                    - English name:                 [%s]
                    - Body type:                    [%s]
                    - Mean radius:                  [%s km]
                    - Average temperature:          [%s C]
                    - Average distance from Sun:    [%s km]
                    - One year lasts:               [%s days]
                    - One day lasts:                [%s h]
                    - Gravity:                      [%s m/s²]
                    - Discovered by:                [%s]
                    - Discovered date:              [%s]
                    - Moons:                        [%s]
                    """.formatted(
                solarSystemDetails.getEnglishName(),
                solarSystemDetails.getBodyType(),
                solarSystemDetails.getMeanRadius(),
                kelvinToCelsius(solarSystemDetails.getAvgTemp()),
                formatDistance(solarSystemDetails.getSemimajorAxis()),
                solarSystemDetails.getSideralOrbit(),
                solarSystemDetails.getSideralRotation(),
                solarSystemDetails.getGravity(),
                solarSystemDetails.getDiscoveredBy(),
                solarSystemDetails.getDiscoveryDate(),
                moonsList
        );
        System.out.println(message);
    }
}
