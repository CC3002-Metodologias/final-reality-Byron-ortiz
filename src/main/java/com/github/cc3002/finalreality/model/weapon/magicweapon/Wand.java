package com.github.cc3002.finalreality.model.weapon.magicweapon;

import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.AbstractMagicWeapon;

public class Wand extends AbstractMagicWeapon {
    public Wand(String name, int weight, int damage, int magicDamage) {
        super(name, weight, damage, magicDamage);
    }

    @Override
    public int getMagicDamage() {
        return super.getMagicDamage();
    }

    @Override
    public void equipToWhiteMage(WhiteMage character) {
        character.setWeapon(this);
    }

    @Override
    public void equipToBlackMage(BlackMage character) {
        character.setWeapon(this);
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
