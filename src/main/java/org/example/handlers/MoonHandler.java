package org.example.handlers;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.handlers.math.DataClarityConverter;
import org.example.handlers.math.DistanceFormatter;
import org.example.handlers.math.TemperatureConverter;

public class MoonHandler {
    private final SolarSystemPlanetDetailsResponse solarSystemDetails;

    public MoonHandler(SolarSystemPlanetDetailsResponse solarSystemDetails) {
        this.solarSystemDetails = solarSystemDetails;
    }

    public void handle() {
        if ("Moon".equals(solarSystemDetails.getBodyType())) {
            String messageMoon = """
                    ------------------------------
                    Moon details :
                    - English name:                    [%s]
                    - Body type:                       [%s]
                    - Mean radius:                     [%s km]
                    - Average temperature:             [%s °C]
                    - Average distance from Planet:    [%s km]
                    - Around Planet:                   [%s]
                    - One year lasts:                  [%s days]
                    - One day lasts:                   [%s h]
                    - Gravity:                         [%s m/s²]
                    - Discovered by:                   [%s]
                    - Discovered date:                 [%s]
                                        
                    """.formatted(
                    solarSystemDetails.getEnglishName(),
                    solarSystemDetails.getBodyType(),
                    solarSystemDetails.getMeanRadius(),
                    TemperatureConverter.kelvinToCelsius(solarSystemDetails.getAvgTemp()),
                    DistanceFormatter.formatDistance(solarSystemDetails.getSemimajorAxis()),
                    DataClarityConverter.convertAroundPlanetForMoon(solarSystemDetails.getAroundPlanet()),
                    solarSystemDetails.getSideralOrbit(),
                    solarSystemDetails.getSideralRotation(),
                    solarSystemDetails.getGravity(),
                    solarSystemDetails.getDiscoveredBy(),
                    solarSystemDetails.getDiscoveryDate()
            );
            System.out.println(messageMoon);
        }
    }
}
