package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IPCharacter extends ICharacter {

    /**
     * returns the character's equippedWeapon
     */
    public IWeapon getEquippedWeapon();
    /**
     * equips a weapon to some character
     */
    public void equipWeapon(IWeapon weapon);

    public String getCharacterClass();
}
