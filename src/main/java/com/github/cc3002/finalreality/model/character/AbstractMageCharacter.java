package com.github.cc3002.finalreality.model.character;


import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the mage characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class  AbstractMageCharacter extends AbstractPlayerCharacter {

    /**
     * Creates a new abstract class to all mage  characters.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param healthPoints
     *     the health's character
     * @param defensePoints
     *     the defensePoints of a character
     * @param equippedWeapon
     *     character's equipped weapon
     * @param equippedSpell
     *     mage's equipped spell
     * @param mana
     *     mage's energy to summon spells
     */
    protected Spell equippedSpell = null;
    protected int mana;

    public AbstractMageCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue, Weapon weapon,
                                 Spell equippedSpell, int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
        this.equippedSpell = equippedSpell;
        this.mana = mana;
    }

    @Override
    public abstract String getCharacterClass();

    public Spell getEquippedSpell() {
        return equippedSpell;
    }

    public void equipSpell(Spell equippedSpell) {
        this.equippedSpell = equippedSpell;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
