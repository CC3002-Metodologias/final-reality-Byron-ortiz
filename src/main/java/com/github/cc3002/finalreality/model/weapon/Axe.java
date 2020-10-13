package com.github.cc3002.finalreality.model.weapon;

public class Axe extends AbstractWeapon {

    public Axe(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Axe)) {
            return false;
        }
        return super.equals(o);
    }
    @Override
    public String getType() {
        return "Axe";
    }

}
