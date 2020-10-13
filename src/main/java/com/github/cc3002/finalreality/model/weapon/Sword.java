package com.github.cc3002.finalreality.model.weapon;

public class Sword extends AbstractWeapon {

    public Sword(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Sword)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getType() {
        return "Sword";
    }
}
