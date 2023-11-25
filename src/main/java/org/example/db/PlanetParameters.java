package org.example.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.api.le_systeme_solarie.AroundPlanet;
import org.example.api.le_systeme_solarie.Moon;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlanetParameters {
    private Long id;
    private String englishName; // Angielska nazwa
    private String bodyType; // Typ ciała Niebieskiego ( księżyc , planeta, asteroida itd) informacja przydatna do funkcji sortujących
    private boolean isPlanet;  // true /false czy jest Planetą - nie wiem czy się to przyda w przyszłości? :)
    private Moon[] moons;
    private Double avgTemp;  // średnia temperatura w Kelvinach
    private Double sideralOrbit; // rok trwa ile dni
    private Double sideralRotation;
    private Double gravity;  // siła grawitacji potrzeba do wyliczenia wagi przedmiotów na danej planecie /księżycu
    private String discoveredBy; // kto odkrył
    private String discoveryDate; // kiedy odkrył
    private Double semimajorAxis; // średnia odległość od Ciała Niebieskiego na którym orbituje obiekt Planety od Słońca / księżyce od Planety
    private Double meanRadius;  // średnica Obiektu
    private AroundPlanet aroundPlanet; // informacja przy jakiej planecie krąży dany obiekt głównie chodzi o Księżyc :) Przyda się do tworzenia List księżyców danej planety.


}
