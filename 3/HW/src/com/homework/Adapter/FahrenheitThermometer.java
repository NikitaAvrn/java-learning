package com.homework.Adapter;

import java.util.Random;

public class FahrenheitThermometer {
    public double getTemperature() {
        Random rnd = new Random();
        int min = -10;
        int max = 110;
        return min + (max - min) * rnd.nextDouble();
    }
}
