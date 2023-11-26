package org.example.handlers.math;
import org.example.api.le_systeme_solarie.AroundPlanet;
import org.example.api.le_systeme_solarie.Moon;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataClarityConverter {
    public static String convertMoonsList(Moon[] moons) {
        return Arrays.stream(moons)
                .map(Moon::getMoon)
                .collect(Collectors.joining(", "));
    }

    public static String convertAroundPlanetForMoon(AroundPlanet planet) {
        String orginalApiText = planet.toString();
        Pattern pattern = Pattern.compile("AroundPlanet\\(planet=([a-zA-Z]+)\\)");
        Matcher matcher = pattern.matcher(orginalApiText);
        if (matcher.find()) {
            String planetName = matcher.group(1);
            String updatedText = orginalApiText.replace("AroundPlanet(planet=" + planetName + ")", planetName);

            return updatedText;
        } else {
            return orginalApiText;
        }
    }
}

