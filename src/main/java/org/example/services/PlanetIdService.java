package org.example.services;

import org.example.api.le_systeme_solarie.Bodies;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlanetIdService {
 //  List<Bodies> solarSystemBodies = listSolarSystemBodies();

 //  public static List<Bodies> listSolarSystemBodies() {
 //      List<Bodies> solarSystemBodiesList = new ArrayList<>();

 //      String apiUrl = "https://api.le-systeme-solaire.net/rest.php/bodies";

 //      try {
 //          HttpClient client = HttpClient.newHttpClient();
 //          HttpRequest request = HttpRequest.newBuilder()
 //                  .uri(URI.create(apiUrl))
 //                  .GET()
 //                  .build();

 //          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

 //          if (response.statusCode() == 200) {
 //              String responseBody = response.body();
 //              solarSystemBodiesList = extractSolarSystemBodies(responseBody);
 //          } else {
 //              System.out.println("Received non-OK response: " + response.statusCode());
 //          }
 //      } catch (Exception e) {
 //          e.printStackTrace();
 //      }

 //      return solarSystemBodiesList;
 //  }

 //  private static List<Bodies> extractSolarSystemBodies(String responseBody) {
 //      List<Bodies> solarSystemBodiesList = new ArrayList<>();

 //      String regex = "\"id\":\"([^\"]+)\",\"name\":\"([^\"]+)\",\"englishName\":\"([^\"]+)\"";
 //      Pattern pattern = Pattern.compile(regex);
 //      Matcher matcher = pattern.matcher(responseBody);

 //      while (matcher.find()) {
 //          String id = matcher.group(1);
 //          String name = matcher.group(2);
 //          String englishName = matcher.group(3);

 //          Bodies solarSystemBody = new Bodies(id, name, englishName);
 //          solarSystemBodiesList.add(solarSystemBody);
 //      }

 //      return solarSystemBodiesList;
 //  }
}