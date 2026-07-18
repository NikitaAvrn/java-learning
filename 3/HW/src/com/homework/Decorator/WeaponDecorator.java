package com.homework.Decorator;

public abstract class WeaponDecorator implements Weapon {
    protected final Weapon weapon;
    protected double weight;
    protected int damage;
    protected String description;

    public WeaponDecorator(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public double getWeight() {
        return this.weapon.getWeight() + this.weight;
    }

    @Override
    public int getDamage() {
        return this.weapon.getDamage() + this.damage;
    }

    @Override
    public String getDescription() {
        return this.weapon.getDescription() + this.description;
    }

    @Override
    public String toString() {
        return String.format("Оружие: %s; вес: %.2f; урон: %d", this.getDescription(), this.getWeight(),
                this.getDamage());
    }
}
