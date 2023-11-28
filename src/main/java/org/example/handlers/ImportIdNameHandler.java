package org.example.handlers;

import lombok.AllArgsConstructor;
import org.example.api.le_systeme_solarie.Bodies;
import org.example.services.PlanetIdService;
import org.example.services.PlanetService;

import java.util.Scanner;
public class ImportIdNameHandler {
    private PlanetService planetService;
    private PlanetIdService planetIdService;

//  public ImportIdNameHandler() {
//  }

//      public void setPlanetService (PlanetService planetService){
//          this.planetService = planetService;
//      }

//      public void setPlanetIdService (PlanetIdService planetIdService){
//          this.planetIdService = planetIdService;
//      }
//
//  public void handleID() {
//      System.out.println("Enter the Planet/Moon name you want to find");
//      Scanner scPlanetToFind = new Scanner(System.in);
//      String userInputPlanetNameToFindByID = scPlanetToFind.nextLine();

//
//          for (Bodies body : planetIdService.listSolarSystemBodies()) {
//              if (body.getId().equalsIgnoreCase(userInputPlanetNameToFindByID)
//                      || body.getName().equalsIgnoreCase(userInputPlanetNameToFindByID)
//                      || body.getEnglishName().equalsIgnoreCase(userInputPlanetNameToFindByID)) {
//                  planetService.setPlanetId(body.getId());
//              }
//          }
//      } else {
//          System.out.println("ERROR!!! PlanetService is null");
//      }
//  }
//
}