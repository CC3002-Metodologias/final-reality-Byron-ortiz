package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.ICharacter;
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
     * Equips a weapon to some character, calls equipWeaponTo..() methods on IWeapon for double dispatch.
     */
    void equipWeapon(IWeapon weapon);

    /**
     * checks if a character has weapon
     */
    boolean hasWeapon();

    /**
     * Set weapon to null.
     */
    void setNullWeapon();
}
