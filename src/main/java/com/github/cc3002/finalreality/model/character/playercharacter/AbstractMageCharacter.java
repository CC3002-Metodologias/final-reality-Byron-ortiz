package com.github.cc3002.finalreality.model.character.playercharacter;


import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the mage characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class AbstractMageCharacter extends AbstractPlayerCharacter {
    private int mana;


    public AbstractMageCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 IWeapon weapon, int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
        this.mana = mana;
    }

    @Override
    public abstract String getCharacterClass();

    /**
     * returns the character's mana
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * resets the character's mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        String out = super.toString();
        out += "MANA : " + Integer.toString(getMana()) + "\n";
        return out;
    }
}
