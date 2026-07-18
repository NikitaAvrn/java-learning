package com.homework.Decorator;

public class BayonetDecorator extends WeaponDecorator {

    public BayonetDecorator(Weapon weapon) {
        super(weapon);
        this.damage = 15;
        this.weight = .5;
        this.description = " + Штык нож";
    }

    @Override
    public void fire() {
        this.weapon.fire();
    }

    public void meleeAttack() {
        System.out.println(String.format("Удар штыком в ближнем бою на %d урона!", this.damage));
    }
}
