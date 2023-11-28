package org.example.handlers;

import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;
import org.example.db.PlanetDataEntity;
import org.example.db.PlanetDataEntityMapper;
import org.example.services.PlanetService;

import java.util.Scanner;

import static org.example.Main.DATA_BASE;
import static org.example.handlers.math.WeightCalculator.EARTH_GRAVITY;

public class CheckWeigtOnPlanetHandler {
    public void weightHandle() {
        System.out.println("Enter the Planet/Moon name you want to check weight:");
        Scanner scPlanetToFind = new Scanner(System.in);
        String userInputPlanetToFind = scPlanetToFind.nextLine();
        System.out.println("Enter the weight value you want to check:");
        Scanner scWeightValue =new Scanner(System.in);
        Double userWeightValue = scWeightValue.nextDouble();
        final SolarSystemPlanetDetailsResponse gravityDetails;
        if (isThisPlanetCached(userInputPlanetToFind)) {
            final PlanetDataEntity planetByName = DATA_BASE.getPlanetByName(userInputPlanetToFind).orElseThrow();
            gravityDetails = PlanetDataEntityMapper.toSolarResponse(planetByName);
        } else {
            gravityDetails = new PlanetService().getPlanetDetailsFromSystemeSolarie(userInputPlanetToFind);
        }
        if(gravityDetails.getGravity()!= null){
            Double celestialGravity = gravityDetails.getGravity();
            Double weightOnCelestial = userWeightValue * celestialGravity / EARTH_GRAVITY;
            System.out.printf("The object weighs %s kg on Earth, while on %s its weight would be approximately %.2f kg!%n", userWeightValue, gravityDetails.getEnglishName(), weightOnCelestial);
        }
    }

    private boolean isThisPlanetCached(String userInputPlanetToFind) {
        return DATA_BASE.existsByName(userInputPlanetToFind);
    }
}
