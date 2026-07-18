package com.homework.Decorator;

public class SilencerDecorator extends WeaponDecorator {
    public SilencerDecorator(Weapon weapon) {
        super(weapon);
        this.weight = 0.3;
        this.damage = -2;
        this.description = " + Глушитель";
    }

    @Override
    public void fire() {
        System.out.println("Выстрел! (Очень тихий выстрел)");
    }

}
