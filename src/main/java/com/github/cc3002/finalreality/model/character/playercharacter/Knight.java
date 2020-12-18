package com.github.cc3002.finalreality.model.character.playercharacter;

import com.github.cc3002.finalreality.model.character.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a Knight character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class Knight extends AbstractPlayerCharacter {



    public Knight(@NotNull String name, int healthPoints,
                  int defensePoints, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  IWeapon weapon) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        weapon.equipToKnight(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Knight)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String getCharacterClass() {
        return "Knight";
    }
}
