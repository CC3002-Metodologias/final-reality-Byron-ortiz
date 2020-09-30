package com.github.cc3002.finalreality.model.weapon;

public class Sword extends AbstractNormalWeapon {

    public Sword(String name, int weight, int damage) {
        super(name, weight, damage);
    }


    @Override
    public String getType() {
        return "Sword";
    }
}
