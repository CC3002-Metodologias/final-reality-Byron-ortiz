package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a playable character from the game.
 * A playable character can only be controlled by a person.
 * This interface will be util to define the party's.
 *
 * @author <Byron Ortiz>
 */
public interface IPCharacter extends ICharacter {

    /**
     * Returns the character's equippedWeapon.
     */
    IWeapon getEquippedWeapon();

    /**
     * Equips a weapon to some character.
     */
    void equipWeapon(IWeapon weapon);

    /**
     * Returns the character's type.
     */
    String getCharacterClass();
}
