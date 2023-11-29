package org.example;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.db.PlanetsDetailsDB;
import org.example.handlers.CheckWeigtOnPlanetHandler;
import org.example.handlers.FindByPlanetHandler;
import org.example.handlers.ImportIdNameHandler;
import org.example.services.PlanetService;

import java.util.Scanner;

public class Main {
    public static final PlanetsDetailsDB DATA_BASE = new PlanetsDetailsDB();
    public static void main(String[] args) {
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
