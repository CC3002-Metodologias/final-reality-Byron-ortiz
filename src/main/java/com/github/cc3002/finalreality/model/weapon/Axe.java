package com.github.cc3002.finalreality.model.weapon;

public class Axe extends AbstractNormalWeapon {

    public Axe(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "Axe";
    }

    @Override
    protected int getDamage() {
        return this.damage;
    }
}
