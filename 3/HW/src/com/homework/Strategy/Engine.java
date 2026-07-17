package com.homework.Strategy;

public class Engine {
    private int power;
    private int recovery;
    private boolean espEnabled;

    public Engine() {
        this.power = 80;
        this.recovery = 20;
        this.espEnabled = true;
    }

    public void setPower(int power) throws Exception {
        if (power >= 0 && power <= 100) {
            this.power = power;
        } else {
            throw new Exception("Мощность изменяется в пределах от 0% до 100%");
        }
    }

    public void setRocovery(int recovery) throws Exception {
        if (recovery >= 0 && recovery <= 100) {
            this.recovery = recovery;
        } else {
            throw new Exception("Режим рекуперации меняется в пределах от 0% до 100%");
        }
    }

    public void setEspEnabled(boolean espEnabled) {
        this.espEnabled = espEnabled;
    }

    @Override
    public String toString() {
        return String.format("Мощность двигателя: %d%nРежим рекуперации: %d%nESP включен: %s%n", this.power,
                this.recovery, this.espEnabled);
    }
}
