package db;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlanetsDetailsDB {
    //TODO: Trzeba zrobić cały C.R.U.D oraz testy !!! :(
    private static final Map<Long, PlanetDataEntity> dataBase = new HashMap<>(); // baza danych przechowywana w mapie

    // pobieranie planety poprzez wpisanie wartość klucza
    public Optional<PlanetDataEntity> get(Long id) {
        return Optional.ofNullable(dataBase.get(id));
    }

    public PlanetDataEntity add(PlanetDataEntity entity) {
        return dataBase.put(entity.getId(), entity);

    }

    public void delete(Long id) {
        dataBase.remove(id);
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
}


