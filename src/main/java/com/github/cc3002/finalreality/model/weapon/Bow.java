package com.github.cc3002.finalreality.model.weapon;

public class Bow extends AbstractNormalWeapon {
    public Bow(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public String getType() {
        return "Bow";
    }
}
