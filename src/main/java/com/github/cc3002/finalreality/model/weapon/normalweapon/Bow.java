package com.github.cc3002.finalreality.model.weapon.normalweapon;

import com.github.cc3002.finalreality.model.character.playercharacter.Engineer;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;

public class Bow extends AbstractWeapon {
    public Bow(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public void equipToThief(Thief character) {
        character.setWeapon(this);
    }

    @Override
    public void equipToEngineer(Engineer character) {
        character.setWeapon(this);
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
