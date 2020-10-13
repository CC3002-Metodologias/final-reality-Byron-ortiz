package com.github.cc3002.finalreality.model.weapon;

public class Wand extends AbstractMagicWeapon {
    public Wand(String name, int weight, int damage, int magicDamage) {
        super(name, weight, damage, magicDamage);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Wand)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getType() {
        return "Wand";
    }
}
