package org.example.db;

import org.example.api.le_systeme_solarie.AroundPlanet;
import org.example.api.le_systeme_solarie.Moon;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetDataEntityMapper {

    public static PlanetDataEntity from(SolarSystemPlanetDetailsResponse dto) {
        return new PlanetDataEntity(null, dto.getEnglishName(), dto.getBodyType(),
         new PlanetParameters(
                dto.getNumericId(),
                dto.getEnglishName(),
                dto.getBodyType(),
                dto.isPlanet(),
                dto.getMoons(),
                dto.getAvgTemp(),
                dto.getSideralOrbit(),
                dto.getSideralRotation(),
                dto.getGravity(),
                dto.getDiscoveredBy(),
                dto.getDiscoveryDate(),
                dto.getSemimajorAxis(),
                dto.getMeanRadius(),
                dto.getAroundPlanet()
        ));
    }
    public static SolarSystemPlanetDetailsResponse toSolarResponse (PlanetDataEntity entity){
        final PlanetParameters planetParameters = entity.getParameters();
        return  new SolarSystemPlanetDetailsResponse(planetParameters.getId().toString(),
                planetParameters.getEnglishName(),
                planetParameters.getBodyType(),
                planetParameters.isPlanet(),
                planetParameters.getMoons(),
                planetParameters.getAvgTemp(),
                planetParameters.getSideralOrbit(),
                planetParameters.getSideralRotation(),
                planetParameters.getGravity(),
                planetParameters.getDiscoveredBy(),
                planetParameters.getDiscoveryDate(),
                planetParameters.getSemimajorAxis(),
                planetParameters.getMeanRadius(),
                null

        );
    }

    private static Moon[] mapMoons(List<Moon> moons) {
        return moons.toArray(new Moon[0]);
    }

    private static List<Moon> mapMoonsToSolarResponse(Moon[] moons) {
        return Arrays.asList(moons);
    }
}
