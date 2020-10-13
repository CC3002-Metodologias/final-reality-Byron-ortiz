package com.github.cc3002.finalreality.model.weapon;

public class Bow extends AbstractWeapon {
    public Bow(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Bow)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getType() {
        return "Bow";
    }
}
