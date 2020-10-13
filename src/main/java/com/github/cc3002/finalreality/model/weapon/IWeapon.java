package com.github.cc3002.finalreality.model.weapon;

/**
 * Interface for any weapon's game.
 */
public interface IWeapon {
    /**
     * Returns the name of a weapon.
     */
    String getName();

    /**
     * Returns the weight of a weapon.
     */
    int getWeight();

    /**
     * Returns the type of a weapon.
     */
    String getType();

    /**
     * Returns the damage of a weapon, could be magicDamage or damage.
     */
    int getDamage();
    /**
     * We should add some other common methods for all weapons.
     */


}
