package org.example.handlers;

import lombok.AllArgsConstructor;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import static org.example.handlers.math.DistanceFormatter.formatDistance;

@AllArgsConstructor
public class AsteroidHandler {
    private final SolarSystemPlanetDetailsResponse solarSystemDetails;

    public void handle(){
        String messageAsteroid = """
                    ------------------------------
                    Planet details :
                    - English name:                 [%s]
                    - Body type:                    [%s]
                    - Mean radius:                  [%s km]
                    - Average distance from Sun:    [%s km]
                    - One year lasts:               [%s days]
                    - Discovered by:                [%s]
                    - Discovered date:              [%s]
                    """.formatted(
                solarSystemDetails.getEnglishName(),
                solarSystemDetails.getBodyType(),
                solarSystemDetails.getMeanRadius(),
                formatDistance(solarSystemDetails.getSemimajorAxis()),
                solarSystemDetails.getSideralOrbit(),
                solarSystemDetails.getDiscoveredBy(),
                solarSystemDetails.getDiscoveryDate()
        );
        System.out.println(messageAsteroid);
    }
}
