package com.homework.Strategy;

public class PowerDrive implements Drive {
    @Override
    public void accelerate(Engine engine) {
        engine.setEspEnabled(true);
        try {
            engine.setPower(100);
            System.err.println("Резкий разгон...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void release(Engine engine) {
        try {
            engine.setRocovery(0);
            System.err.println("Рекуперация энергии отключена");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String info() {
        return "Режим Power включен";
    }

}
