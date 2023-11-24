package handlers;

import api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import services.PlanetService;

import java.util.Scanner;

public class FindByPlanetHandler {
    public void handle() {
        System.out.println("Enter the Planet/Moon name you want to find");
        Scanner scPlanetToFind = new Scanner(System.in);
        String userInputPlanetToFind = scPlanetToFind.nextLine();

        final SolarSystemPlanetDetailsResponse solarSystemDetails;
        if(isThisPlanetCached(userInputPlanetToFind)){
            solarSystemDetails = DATA_BASE.getPlanetByName();
        } else {
            solarSystemDetails = new PlanetService().getPlanetDetailsFromSystemeSolarie(userInputPlanetToFind);
        }String message = """
							------------------------------
							Planet/Moon details :
							- englishName: 		[%s]
							- meanRadius:		[%s]
							- semimajorAxis: 	[%s]
							- gravity: 		    [%s]
							""".formatted(
                solarSystemDetails.getEnglishName(),
                solarSystemDetails.getMeanRadius(),
                solarSystemDetails.getSemimajorAxis(),
                solarSystemDetails.getGravity());
        System.out.println(message);
    }


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
