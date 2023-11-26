package org.example.handlers.math;

public class TemperatureConverter {
    public static double kelvinToCelsius(double kelvin){
        double celsius = kelvin - 273.15;
        return Math.round(celsius * 100.0) / 100.0;
    }
}
