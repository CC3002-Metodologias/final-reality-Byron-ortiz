package com.github.cc3002.finalreality.model.weapon;

public class Wand extends AbstractMagicWeapon {
    public Wand(String name, int weight, int magicDamage) {
        super(name, weight, magicDamage);
    }

    @Override
    public String getType() {
        return "Wand";
    }
}
