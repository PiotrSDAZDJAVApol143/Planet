package db;

import java.util.HashMap;
import java.util.Map;
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

}
