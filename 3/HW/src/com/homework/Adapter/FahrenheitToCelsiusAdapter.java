package com.homework.Adapter;

public class FahrenheitToCelsiusAdapter implements CelsiusThermometer {
    private FahrenheitThermometer fahrenheitThermometer;

    public FahrenheitToCelsiusAdapter(FahrenheitThermometer fahrenheitThermometer) {
        this.fahrenheitThermometer = fahrenheitThermometer;
    }

    @Override
    public double getCelsiusTemperature() {
        double fahrenheit = this.fahrenheitThermometer.getTemperature();
        System.out.println(String.format("[Лог Адаптера] Температура: %.1f °F%n", fahrenheit));
        return (fahrenheit - 32) / 1.8;
    }
}
