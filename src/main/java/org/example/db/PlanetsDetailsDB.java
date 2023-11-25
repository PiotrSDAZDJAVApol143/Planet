package org.example.db;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PlanetsDetailsDB {
    //TODO: Trzeba zrobić cały C.R.U.D oraz testy !!! :(
    private static final Map<Long, PlanetDataEntity> dataBase = new HashMap<>();
    private static Long PLANET_DATA_ENTITY_ID = 1L;
    private static Long MOON_DATA_ENTITY_ID = 1L;

    public Optional<PlanetDataEntity> getId(Long id){return Optional.ofNullable(dataBase.get(id));
    }
    public PlanetDataEntity add(PlanetDataEntity entity) {
        return dataBase.put(entity.getId(), entity);

    }

    public PlanetDataEntity update(PlanetDataEntity planetDataEntity) {
        final PlanetDataEntity toChange = dataBase.get(planetDataEntity.getId());
        //edytowanie
        toChange.setId(planetDataEntity.getId());
        toChange.setPlanet(planetDataEntity.isPlanet());
        toChange.setEnglishName(planetDataEntity.getEnglishName());
        toChange.setParameters(planetDataEntity.getParameters());
        return dataBase.put(planetDataEntity.getId(), toChange);


    }

    public void delete(Long id) {
        dataBase.remove(id);
    }

    public boolean existsByName(String userInput){
        return false;
    }

    public Optional<PlanetDataEntity> getPlanetByName(String planetName) {
        PlanetDataEntity result = null;
        for(var entry: dataBase.entrySet()) {
            final PlanetDataEntity entity = entry.getValue();
            final boolean isEquals = Objects.equals(entity.getEnglishName(),planetName);

            if(isEquals){
                result= entity;
            }
        }
        return  Optional.ofNullable(result);
    }
}
