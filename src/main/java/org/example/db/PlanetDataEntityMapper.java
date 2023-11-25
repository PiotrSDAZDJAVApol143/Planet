package org.example.db;

import org.example.api.le_systeme_solarie.Moon;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.util.Arrays;

public class PlanetDataEntityMapper {

    public static PlanetDataEntity from(SolarSystemPlanetDetailsResponse dto) {
        PlanetParameters parameters = new PlanetParameters(
                dto.getNumericId(),
                dto.getEnglishName(),
                dto.getSemimajorAxis(),
                dto.getMoons(),
                dto.getGravity(),
                dto.getMeanRadius()
        );
        return new PlanetDataEntity(
                parameters.getId(),
                parameters.getEnglishName(),
                dto.isPlanet(),
                parameters
        );
    }
    public static SolarSystemPlanetDetailsResponse toSolarResponse (PlanetDataEntity entity){
        final PlanetParameters planetParameters = entity.getParameters();
        return  new SolarSystemPlanetDetailsResponse(planetParameters.getId().toString(),
                planetParameters.getEnglishName(),
                entity.isPlanet(),
                planetParameters.getMoons(),
                planetParameters.getGravity(),
                null,
                planetParameters.getSemimajorAxis(),
                planetParameters.getMeanRadius()
        );
    }
}
