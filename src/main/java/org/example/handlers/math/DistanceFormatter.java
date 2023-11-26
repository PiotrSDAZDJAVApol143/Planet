package org.example.handlers.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DistanceFormatter {
    public static String formatDistance(double distance){
        //zrobienie z doubla Bigdecimala
        BigDecimal distanceBigDecimal = BigDecimal.valueOf(distance);
        //formatowanie na czytelniejszy zapis
        DecimalFormat distanceFormat = new DecimalFormat("#,###,###.##");
        // zwracamy wzór formatowania . format obiekt który będzie formatowany
        return distanceFormat.format(distanceBigDecimal);
    }
}
