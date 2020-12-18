package com.github.cc3002.finalreality.model.character.playercharacter;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a Thief character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class Thief extends AbstractPlayerCharacter {



    public Thief(@NotNull String name, int healthPoints, int defensePoints,
                 @NotNull BlockingQueue<ICharacter> turnsQueue, IWeapon weapon) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        weapon.equipToThief(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Thief)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getCharacterClass() {
        return "Thief";
    }
}
