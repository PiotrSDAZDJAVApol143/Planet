package org.example;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.db.PlanetDataEntity;
import org.example.db.PlanetDataEntityMapper;
import org.example.db.PlanetsDetailsDB;
import org.example.handlers.CheckWeigtOnPlanetHandler;
import org.example.handlers.FindByPlanetHandler;
import org.example.services.PlanetService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final PlanetsDetailsDB DATA_BASE = new PlanetsDetailsDB();
    public static void main(String[] args) {
        final List<String> planetFromSolarSystem = List.of(//"Mercury","Venus",
                "Earth", "Mars", "Jupiter", "Saturn", "Uranus"
                ,"Neptune");
        planetFromSolarSystem.stream()
                .forEach(planetName-> {
                            final SolarSystemPlanetDetailsResponse response = new PlanetService().getPlanetDetailsFromSystemeSolarie(planetName);
                            final PlanetDataEntity entity = PlanetDataEntityMapper.from(response);
                            DATA_BASE.add(entity);
                        });
        var isRunning = true;
        var isFirstRun = true;
        PlanetService planetService = new PlanetService();
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "Q" -> isRunning = false;
                case "P" -> new FindByPlanetHandler().handle();
                case "W" -> new CheckWeigtOnPlanetHandler().weightHandle();
                case "D" -> System.out.println("Under Construction..."); // do zrobienia
                default -> System.out.println("ERROR!!! INVALID INPUT");
            }
            }
        }


    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("""
                    ----------------------
                    Welcome to Astral App!
                    Select an action by entering the appropriate key:
                    type Q to quit
                    type P to get a Planet/Moon Details
                    type W to check the weight on the selected Planet/Moon
                    type D to check how long it will take you to travel to selected Planet/Moon
              
                    ----------------------
                    """);
            isFirstRun = false;
        }
        return isFirstRun;
    }
}
