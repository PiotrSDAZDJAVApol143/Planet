package org.example.handlers;

import org.example.api.le_systeme_solarie.Moon;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.db.PlanetDataEntity;
import org.example.db.PlanetDataEntityMapper;
import org.example.services.PlanetService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Main.DATA_BASE;
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

        String moonsList = Arrays.stream(solarSystemDetails.getMoons())
                .map(Moon::getMoon)
                .collect(Collectors.joining(", "));

        String message = """
                            ------------------------------
                            Planet/Moon details :
                            - English name:        [%s]
                            - Body type:           [%s]
                            - meanRadius:          [%s km]
                            - Average temperature: [%s C]
                            - Average distance:    [%s km]
                            - One year lasts:      [%s days]
                            - One day lasts:       [%s h]
                            - Gravity:             [%s m/s²]
                            - Discovered by:       [%s]
                            - Discovered date:     [%s]
                            - Moons:               [%s]
                            """.formatted(
                solarSystemDetails.getEnglishName(),
                solarSystemDetails.getBodyType(),
                solarSystemDetails.getMeanRadius(),
                kelvinToCelsius(solarSystemDetails.getAvgTemp()),
                solarSystemDetails.getSemimajorAxis(),
                solarSystemDetails.getSideralOrbit(),
                solarSystemDetails.getSideralRotation(),
                solarSystemDetails.getGravity(),
                solarSystemDetails.getDiscoveredBy(),
                solarSystemDetails.getDiscoveryDate(),
                moonsList
        );
        System.out.println(message);
    }
    //TODO:Jest jeszcze sporo poprawek do zrobienia
    // - wyświetlanie informacji - Zamiana Kelvinów na Celsjusze
    // - formatowanie dystansu. Obecnie pokazuje albo średnią odległość od Słońca albo średnią odległość od planety
    // jeśli to księżyc. Sam zapis też jest mało czytelny chyba wolałbym widzieć 2 870 658 186 km niż: 2.870658186E9 km


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
