package org.example.services;

import org.example.api.HttpClientService;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlanetService {
    private static final HashMap<String, String> solarSystemMap = getSolarSystemMap();
    private static String findID;
    private static HashMap<String, String> getSolarSystemMap() {
        HashMap<String, String> solarSystemMap = new HashMap<>();

        String apiUrl = "https://api.le-systeme-solaire.net/rest.php/bodies";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                solarSystemMap = extractSolarSystemMap(responseBody);
            } else {
                System.out.println("Received non-OK response: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return solarSystemMap;
    }

    private static HashMap<String, String> extractSolarSystemMap(String responseBody) {
        HashMap<String, String> solarSystemMap = new HashMap<>();

        String regex = "\"id\":\"([^\"]+)\",\"name\":\"([^\"]+)\",\"englishName\":\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(responseBody);

        while (matcher.find()) {
            String id = matcher.group(1);
            String name = matcher.group(2);
            String englishName = matcher.group(3);

            solarSystemMap.put(englishName, id);
        }

        return solarSystemMap;
    }

    public SolarSystemPlanetDetailsResponse getPlanetDetailsFromSystemeSolarie(String planetName) {
        findID = searchMapToFindID(planetName);
        
        String baseUrl = "https://api.le-systeme-solaire.net/rest/bodies/" + findID;
        var httpClientService = new HttpClientService<SolarSystemPlanetDetailsResponse>();
        final SolarSystemPlanetDetailsResponse response = httpClientService.getPlanetDetails(baseUrl, SolarSystemPlanetDetailsResponse.class);
    return response;
    }

    private static String searchMapToFindID(String planetName) {
        String id = solarSystemMap.get(planetName);
        if (id == null) {
            throw new RuntimeException("Planet not found: " + planetName);
        }
        return id;
    }
}

