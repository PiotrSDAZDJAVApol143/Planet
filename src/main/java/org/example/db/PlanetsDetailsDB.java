package org.example.db;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PlanetsDetailsDB {
    //TODO: Trzeba zrobić cały C.R.U.D oraz testy !!! :(
    private static final Map<Integer, PlanetDataEntity> dataBase = new HashMap<>();
    private static Integer PLANET_DATA_ENTITY_ID = 1;
    private static Integer MOON_DATA_ENTITY_ID = 1;

    public Optional<PlanetDataEntity> getId(Integer id){return Optional.ofNullable(dataBase.get(id));
    }
  //  public PlanetDataEntity add(PlanetDataEntity planetData){
  //  }

  // public PlanetDataEntity change(PlanetDataEntity planetDataEntity){
  //
  // }

    public void delete(Integer id) {
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
