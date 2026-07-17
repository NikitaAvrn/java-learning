package com.homework;

import com.homework.Strategy.DriftDrive;
import com.homework.Strategy.EcoDrive;
import com.homework.Strategy.ElectricCar;
import com.homework.Strategy.PowerDrive;

public class Main {
    public static void main(String[] args) {
        strategyPattern();
    }

    private static void strategyPattern() {
        System.err.println("Strategy pattern");

        ElectricCar tesla = new ElectricCar(new EcoDrive());
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.err.println(tesla.engineInfo());

        System.err.println(tesla.changeDriveMode(new PowerDrive()));
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.err.println(tesla.engineInfo());

        System.err.println(tesla.changeDriveMode(new DriftDrive()));
        tesla.pressAccelerate();
        tesla.releaseAccelerate();
        System.err.println(tesla.engineInfo());
    }
}