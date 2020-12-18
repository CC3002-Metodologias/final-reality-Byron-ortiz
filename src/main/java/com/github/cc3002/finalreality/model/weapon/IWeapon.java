package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.playercharacter.*;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.WhiteMage;

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
     * Methods to equip weapons for double dispatch.
     *
     */
    void equipToKnight(Knight character);
    void equipToThief(Thief character);
    void equipToEngineer(Engineer character);
    void equipToWhiteMage(WhiteMage character);
    void equipToBlackMage(BlackMage character);

    // We should add some other common methods for all weapons.
}
