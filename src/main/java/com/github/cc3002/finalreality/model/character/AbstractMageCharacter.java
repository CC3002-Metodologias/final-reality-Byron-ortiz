package com.github.cc3002.finalreality.model.character;


import com.github.cc3002.finalreality.model.weapon.IWeapon;
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
     */
    //private Spell equippedSpell = null;
    private int mana;

    public AbstractMageCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue, IWeapon weapon,
                                 /*Spell equippedSpell*/ int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
        //this.equippedSpell = equippedSpell;
        this.mana = mana;
    }

    @Override
    public abstract String getCharacterClass();

    /**
     * returns the character's equippedSpell
     */
    //public Spell getEquippedSpell() {return equippedSpell;}
    /**
     * equips a spell to some mage character (i think this method will change in the future
     * because of the limitations of every mage to equip spells of
     * different types, but i dont know how to do it right now)
     */
    // public void equipSpell(Spell equippedSpell) {this.equippedSpell = equippedSpell;}


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
}
