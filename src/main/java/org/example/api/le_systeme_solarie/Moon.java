package org.example.api.le_systeme_solarie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Moon {
    private String moon;


    //TODO: trzeba sprawdzić dlaczego klasa Moon nie działa w tablicy aby wypisywać przy funkcji detale:
    // np Jowisz - księżyce [ xxxxx]
    // ewentualnie zrezygnujemy z tej opcji jeśli polegniemy :)
}
