package org.example.db;

import java.util.*;

public class PlanetsDetailsDB {
    //TODO: Trzeba zrobić cały C.R.U.D oraz testy !!! :(
    private static final Map<Long, PlanetDataEntity> dataBase = new HashMap<>();
    private static Long PLANET_DATA_ENTITY_ID = 1L;
    private static Long MOON_DATA_ENTITY_ID = 1L;
    Scanner input = new Scanner(System.in);

    public Map showAll() {
        System.out.println(dataBase);
        return dataBase;
    }

    public Optional<PlanetDataEntity> getId(Long id){return Optional.ofNullable(dataBase.get(id));
    }
    public PlanetDataEntity add(PlanetDataEntity entity) {
        return dataBase.put(entity.getId(), entity);

    }

    public void update(Long id, Scanner input) {
        this.input = input;
        PlanetDataEntity planetToChange = dataBase.get(id);
        System.out.println("Planet to change: " + planetToChange);
        System.out.println("----------");
        System.out.println("Current Englishname is: " + planetToChange.getEnglishName());
        System.out.println("Set new EnglishName");
        String newEnglishName = input.next();
        planetToChange.setEnglishName(newEnglishName);
        Optional<PlanetDataEntity> updatedPlanet = Optional.of(new PlanetDataEntity());
        System.out.println(getId(id));
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
