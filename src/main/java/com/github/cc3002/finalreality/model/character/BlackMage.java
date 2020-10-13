package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a Black Mage character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class BlackMage extends AbstractMageCharacter {
    public BlackMage(@NotNull String name, int healthPoints, int defensePoints,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     IWeapon weapon, int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon, mana);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BlackMage)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getCharacterClass() {
        return "Black Mage";
    }
}
