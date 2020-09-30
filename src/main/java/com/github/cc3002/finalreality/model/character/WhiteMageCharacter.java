package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a White Mage character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class WhiteMageCharacter extends AbstractMageCharacter {
    public WhiteMageCharacter(@NotNull String name, int healthPoints, int defensePoints,
                              @NotNull BlockingQueue<ICharacter> turnsQueue, Weapon weapon,
                              Spell equippedSpell, int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon, equippedSpell, mana);
    }

    @Override
    public String getCharacterClass() {
        return "White Mage";
    }
}
