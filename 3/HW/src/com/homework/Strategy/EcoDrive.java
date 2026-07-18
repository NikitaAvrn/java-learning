package com.homework.Strategy;

public class EcoDrive implements Drive {
    @Override
    public void accelerate(Engine engine) {
        engine.setEspEnabled(true);
        try {
            engine.setPower(50);
            System.err.println("Плавный разгон...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void release(Engine engine) {
        try {
            engine.setRocovery(50);
            System.err.println("Рекуперация энергии");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String info() {
        return "Режим Eco включен";
    }
}
