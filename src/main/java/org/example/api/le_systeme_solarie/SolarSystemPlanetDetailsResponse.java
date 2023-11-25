package org.example.api.le_systeme_solarie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class SolarSystemPlanetDetailsResponse {
    private String id; // ID jest Stringiem - jest też
    private String englishName; // Angielska nazwa
    private String bodyType; // Typ ciała Niebieskiego ( księżyc , planeta, asteroida itd) informacja przydatna do funkcji sortujących
    private boolean isPlanet;  // true /false czy jest Planetą - nie wiem czy się to przyda w przyszłości? :)
    private Moon[] moons;
    private Double avgTemp;  // średnia temperatura w Kelvinach
    private Double sideralOrbit; // rok trwa ile dni
    private Double sideralRotation; // ile godzin trwa doba
    private Double gravity;  // siła grawitacji potrzeba do wyliczenia wagi przedmiotów na danej planecie /księżycu
    private String discoveredBy; // kto odkrył
    private String discoveryDate; // kiedy odkrył
    private Double semimajorAxis; // średnia odległość od Ciała Niebieskiego na którym orbituje obiekt Planety od Słońca / księżyce od Planety
    private Double meanRadius;  // średnica Obiektu
    private AroundPlanet aroundPlanet; // informacja przy jakiej planecie krąży dany obiekt głównie chodzi o Księżyc :) Przyda się do tworzenia List księżyców danej planety.


    //TODO: Tu ewentualnie można dodać jakieś nowe informacje i zastanowić się dlaczego discoveredBy - nie działa...
    public Long getNumericId() {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
