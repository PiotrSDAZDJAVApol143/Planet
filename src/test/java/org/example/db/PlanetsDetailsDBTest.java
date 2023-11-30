package org.example.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlanetsDetailsDBTest {
    //    private static final Map<Long, PlanetDataEntity> dataBaseTestMain = new HashMap<>();
    private static final PlanetsDetailsDB dataBase = new PlanetsDetailsDB();
    PlanetsDetailsDB planetsDetailsDB = new PlanetsDetailsDB();
 //   @Test
 //   void should_add_object_to_database() {
 //       //given
 //       PlanetDataEntity planet1 = new PlanetDataEntity(12L, "Moon","Moon",new PlanetParameters // do dokonczenia....);
//
 //       //when
 //       planetsDetailsDB.add(planet1);
//
 //       //then
 //       final var resultOpt = dataBase.getId(12L);
 //       final boolean isPresent = resultOpt.isPresent();
 //       Assertions.assertTrue(isPresent);
 //   }
 //  @Test
 //  void should_get_planet_by_name(){
 //      //given
 //      final long id = 1L;
 //      final String planetName = "Javator";
 //      final PlanetDataEntity planetDataEntity = new PlanetDataEntity();
 //      planetDataEntity.setId(id);
 //      planetDataEntity.setEnglishName(planetName);
 //      dataBase.add(planetDataEntity);

 //      //when
 //      final PlanetDataEntity result = dataBase.getPlanetByName(planetName).orElseThrow();

 //      //then
 //      Assertions.assertEquals(result.getEnglishName(), planetName);

 //  }

 //  private static long createAndAddCelestialBody(Long id, String englishName) {
 //      final PlanetDataEntity newCelestialBody = new PlanetDataEntity();
 //      newCelestialBody.setId(1234l);
 //      newCelestialBody.setEnglishName("Javator");
 //      final PlanetDataEntity add = dataBase.add(newCelestialBody);
 //      return id;
 //  }
}