package org.example.handlers;

import org.example.api.le_systeme_solarie.Moon;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.db.PlanetDataEntity;
import org.example.db.PlanetDataEntityMapper;
import org.example.handlers.math.DataClarityConverter;
import org.example.services.PlanetService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Main.DATA_BASE;
import static org.example.handlers.math.DataClarityConverter.convertAroundPlanetForMoon;
import static org.example.handlers.math.DistanceFormatter.formatDistance;
import static org.example.handlers.math.TemperatureConverter.kelvinToCelsius;

public class FindByPlanetHandler {
    public void handle() {
        System.out.println("Enter the Planet/Moon name you want to find");
        Scanner scPlanetToFind = new Scanner(System.in);
        String userInputPlanetToFind = scPlanetToFind.nextLine();


        final SolarSystemPlanetDetailsResponse solarSystemDetails;
        if (isThisPlanetCached(userInputPlanetToFind)) {
            final PlanetDataEntity planetByName = DATA_BASE.getPlanetByName(userInputPlanetToFind).orElseThrow();
            solarSystemDetails = PlanetDataEntityMapper.toSolarResponse(planetByName);
        } else {
            solarSystemDetails = new PlanetService().getPlanetDetailsFromSystemeSolarie(userInputPlanetToFind);
        }

        if(solarSystemDetails.getBodyType().equals("Planet")) {

            String moonsList = DataClarityConverter.convertMoonsList(solarSystemDetails.getMoons());

            String message = """
                    ------------------------------
                    Planet details :
                    - English name:                 [%s]
                    - Body type:                    [%s]
                    - meanRadius:                   [%s km]
                    - Average temperature:          [%s C]
                    - Average distance from Sun:    [%s km]
                    - One year lasts:               [%s days]
                    - One day lasts:                [%s h]
                    - Gravity:                      [%s m/s²]
                    - Discovered by:                [%s]
                    - Discovered date:              [%s]
                    - Moons:                        [%s]
                    """.formatted(
                    solarSystemDetails.getEnglishName(),
                    solarSystemDetails.getBodyType(),
                    solarSystemDetails.getMeanRadius(),
                    kelvinToCelsius(solarSystemDetails.getAvgTemp()),
                    formatDistance(solarSystemDetails.getSemimajorAxis()),
                    solarSystemDetails.getSideralOrbit(),
                    solarSystemDetails.getSideralRotation(),
                    solarSystemDetails.getGravity(),
                    solarSystemDetails.getDiscoveredBy(),
                    solarSystemDetails.getDiscoveryDate(),
                    moonsList
            );
            System.out.println(message);
        } else if (solarSystemDetails.getBodyType().equals("Moon")) {

            String messageMoon = """
                    ------------------------------
                    Moon details :
                    - English name:                    [%s]
                    - Body type:                       [%s]
                    - meanRadius:                      [%s km]
                    - Average temperature:             [%s C]
                    - Average distance from Planet:    [%s km]
                    - Around Planet:                   [%s]
                    - One year lasts:                  [%s days]
                    - One day lasts:                   [%s h]
                    - Gravity:                         [%s m/s²]
                    - Discovered by:                   [%s]
                    - Discovered date:                 [%s]
                    
                    """.formatted(
                    solarSystemDetails.getEnglishName(),
                    solarSystemDetails.getBodyType(),
                    solarSystemDetails.getMeanRadius(),
                    kelvinToCelsius(solarSystemDetails.getAvgTemp()),
                    formatDistance(solarSystemDetails.getSemimajorAxis()),
                    convertAroundPlanetForMoon(solarSystemDetails.getAroundPlanet()),
                    solarSystemDetails.getSideralOrbit(),
                    solarSystemDetails.getSideralRotation(),
                    solarSystemDetails.getGravity(),
                    solarSystemDetails.getDiscoveredBy(),
                    solarSystemDetails.getDiscoveryDate()
            );
            System.out.println(messageMoon);

        }
    }
    //TODO:Jest jeszcze sporo poprawek do zrobienia
    // Stworzenie logiki wykrywającej gdy zmienna zwraca 0 - wyświetlać powinna wtedy "brak danych"


    private boolean isThisPlanetCached(String userInputPlanetToFind){
        return DATA_BASE.existsByName(userInputPlanetToFind);
    }
}


//TODO: będą 2 albo 3 handlery albo wszystkie w 1 klasie albo każdy handler na swoją klase.
// 1 - wypisze detale planety / księżyca
// 2- Jeśli User wybierze "sprawdz wagę" poprosi o wpisanie wagi jaką chce porównać i wyświetli po działaniu matematycznym wagę na danej planecie
// 3- Jeśli User wybierze opcje nr 3 " sprawdz kiedy dolecę" po wpisaniu czym i jaką prędkością lub wybierze domyślne wartości
// dodamy kilka obiektów "pojazdów" typowo związanych z podróżami kosmicznymi tj:
// statek Apollo 11  / Rakieta Saturn V / SpaceX Starship
// wyliczy jak długo będzie leciał ( lata / miesiące / dni) i poda datę z LocalDate
