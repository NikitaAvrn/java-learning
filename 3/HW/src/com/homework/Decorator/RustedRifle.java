package com.homework.Decorator;

public class RustedRifle implements Weapon {
    private final double weight;
    private final int damage;
    private final String description;

    public RustedRifle() {
        this.damage = 20;
        this.description = "Ржавый автомат";
        this.weight = 3.5;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void fire() {
        System.out.println("Выстрел! (Очень громкий выстрел)");
    }

    @Override
    public String toString() {
        return String.format("Оружие: %s; вес: %.2f; урон: %d", this.description, this.weight, this.damage);
    }
}
