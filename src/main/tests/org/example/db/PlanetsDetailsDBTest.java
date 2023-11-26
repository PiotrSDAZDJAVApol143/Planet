package org.example.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlanetsDetailsDBTest {
//    private static final Map<Long, PlanetDataEntity> dataBaseTestMain = new HashMap<>();
    private static final PlanetsDetailsDB dataBase = new PlanetsDetailsDB();
    @Test
    void should_add_object_to_database() {
        //given
        PlanetsDetailsDB planetsDetailsDB = new PlanetsDetailsDB();

        PlanetDataEntity planet1 = new PlanetDataEntity(12L, "Moon",false);

        //when
        planetsDetailsDB.add(planet1);

        //then
        final var resultOpt = dataBase.getId(12L);
        final boolean isPresent = resultOpt.isPresent();
        Assertions.assertTrue(isPresent);
    }

    private static long createAndAddCelestialBody(Long id, String englishName) {
        final PlanetDataEntity newCelestialBody = new PlanetDataEntity();
        newCelestialBody.setId(1234l);
        newCelestialBody.setEnglishName("Javator");
        final PlanetDataEntity add = dataBase.add(newCelestialBody);
        return id;
    }
}