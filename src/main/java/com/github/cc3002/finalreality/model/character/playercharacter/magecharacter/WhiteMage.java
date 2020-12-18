package com.github.cc3002.finalreality.model.character.playercharacter.magecharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.playercharacter.AbstractMageCharacter;
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
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     IWeapon weapon, int mana) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon, mana);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        weapon.equipToWhiteMage(this);
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
