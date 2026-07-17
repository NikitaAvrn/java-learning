package com.homework.Builder;

import java.util.ArrayList;
import java.util.List;

public class MadMaxCar {
    private final String chassis; // Тип кузова/шасси
    private final String engine; // Тип двигателя
    private final int armor; // Толщина брони
    private final boolean hasNitro; // Есть ли закись азота
    private final List<String> weapons; // Список оружия

    private MadMaxCar(Builder builder) {
        this.chassis = builder.chassis;
        this.engine = builder.engine;
        this.armor = builder.armor;
        this.hasNitro = builder.hasNitro;
        this.weapons = builder.weapons;
    }

    @Override
    public String toString() {
        return String.format("Боевая Машина [Шасси=%s, Двигатель=%s, Броня=%d мм, Нитро=%s, Оружие=%s]", chassis,
                engine, armor, hasNitro, weapons);
    }

    public static class Builder {
        private final String chassis;
        private final String engine;
        private int armor = 5;
        private boolean hasNitro = false;
        private List<String> weapons = new ArrayList<String>();

        public Builder(String chassis, String engine) {
            this.chassis = chassis;
            this.engine = engine;
        }

        public Builder setArmor(int armor) {
            this.armor = armor;
            return this;
        }

        public Builder installNitro() {
            this.hasNitro = true;
            return this;
        }

        public Builder addWeapon(String weaponName) {
            this.weapons.add(weaponName);
            return this;
        }

        public MadMaxCar build() {
            if (this.armor > 50 && "Слабое Шасси".equals(this.chassis)) {
                throw new IllegalStateException("Шасси не выдержит такую тяжелую броню!");
            }
            return new MadMaxCar(this);
        }
    }
}
