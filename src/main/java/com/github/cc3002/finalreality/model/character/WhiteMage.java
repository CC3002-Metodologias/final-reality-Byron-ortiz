package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a White Mage character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class WhiteMage extends AbstractMageCharacter {
    public WhiteMage(@NotNull String name, int healthPoints, int defensePoints,
                     @NotNull BlockingQueue<ICharacter> turnsQueue, IWeapon weapon,
                     /*Spell equippedSpell,*/ int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon, /*equippedSpell,*/ mana);
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WhiteMage)) {
            return false;
        }
        return super.equals(o);
    }
    @Override
    public String getCharacterClass() {
        return "White Mage";
    }
}
