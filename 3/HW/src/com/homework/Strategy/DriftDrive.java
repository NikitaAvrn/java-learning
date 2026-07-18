package com.homework.Strategy;

public class DriftDrive implements Drive {
    @Override
    public void accelerate(Engine engine) {
        engine.setEspEnabled(false);
        try {
            engine.setPower(100);
            System.err.println("Занос! Вся мощность на заднюю ось...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void release(Engine engine) {
        try {
            engine.setRocovery(20);
            System.err.println("Рекуперация энергии");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String info() {
        return "Режим Drift включен";
    }

}
