import api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import services.PlanetService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
                    final SolarSystemPlanetDetailsResponse planetDetailsFromSS = new PlanetService().getPlanetDetailsFromSystemeSolarie("jupiter");
                    System.out.println("Planet Name: " + planetDetailsFromSS.getEnglishName() + planetDetailsFromSS.getGravity()+ planetDetailsFromSS.getDiscoveredBy()+ " " + planetDetailsFromSS.getMeanRadius() + " " + planetDetailsFromSS.getSemimajorAxis());

                }
                default -> System.out.println("ERROR!!! INVALID INPUT");
            }
            }
        }


    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("""
                    ----------------------
                    WELCOME!
                    type X to quit
                    type Y to get a Planet/Moon Details
                    type C to show what Planet/Moon you want to find
              
                    ----------------------
                    """);
            isFirstRun = false;
        }
        return isFirstRun;
    }
}
