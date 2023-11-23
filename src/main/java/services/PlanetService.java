package services;

import api.HttpClientService;
import api.le_systeme_solarie.SolarSystemPlanetDetailsResponse;

public class PlanetService {
    public SolarSystemPlanetDetailsResponse getPlanetDetailsFromSystemeSolarie(String planetName) {
        String jupiterId = "jupiter";
        String baseUrl = "https://api.le-systeme-solaire.net/rest/bodies/" + jupiterId;
        var httpClientService = new HttpClientService<SolarSystemPlanetDetailsResponse>();
        final SolarSystemPlanetDetailsResponse response = httpClientService.getPlanetDetails(baseUrl, SolarSystemPlanetDetailsResponse.class);
    return response;
    }
}
