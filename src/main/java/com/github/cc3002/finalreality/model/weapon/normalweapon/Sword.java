package com.github.cc3002.finalreality.model.weapon.normalweapon;

import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;

public class Sword extends AbstractWeapon {

    public Sword(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public void equipToKnight(Knight character) {
        character.setWeapon(this);
    }

    @Override
    public void equipToThief(Thief character) {
        character.setWeapon(this);
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
