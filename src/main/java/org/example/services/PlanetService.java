package org.example.services;

import org.example.api.HttpClientService;
import org.example.api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

public class PlanetService {
    public SolarSystemPlanetDetailsResponse getPlanetDetailsFromSystemeSolarie(String planetName) {
        String planetIdName = planetName;
        String baseUrl = "https://api.le-systeme-solaire.net/rest/bodies/" + planetIdName;
        var httpClientService = new HttpClientService<SolarSystemPlanetDetailsResponse>();
        final SolarSystemPlanetDetailsResponse response = httpClientService.getPlanetDetails(baseUrl, SolarSystemPlanetDetailsResponse.class);
    return response;
    }
}

