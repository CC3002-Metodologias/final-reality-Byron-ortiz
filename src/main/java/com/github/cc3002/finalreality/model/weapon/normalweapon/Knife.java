package com.github.cc3002.finalreality.model.weapon.normalweapon;

import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;

public class Knife extends AbstractWeapon {
    public Knife(String name, int weight, int damage) {
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
    public void equipToBlackMage(BlackMage character) {
        character.setWeapon(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Knife)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getType() {
        return "Knife";
    }
}
