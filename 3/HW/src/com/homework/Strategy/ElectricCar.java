package com.homework.Strategy;

public class ElectricCar {
    private Drive driveMode;
    private Engine engine;

    public ElectricCar(Drive initialMode) {
        this.engine = new Engine();
        this.driveMode = initialMode;
    }

    public String changeDriveMode(Drive driveMode) {
        this.driveMode = driveMode;
        return this.driveMode.info();
    }

    public void pressAccelerate() {
        this.driveMode.accelerate(engine);
    }

    public void releaseAccelerate() {
        this.driveMode.release(engine);
    }

    public String engineInfo() {
        return this.engine.toString();
    }
}