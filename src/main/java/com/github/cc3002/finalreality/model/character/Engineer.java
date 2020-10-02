package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a Engineer character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class Engineer extends AbstractPlayerCharacter {
    public Engineer(@NotNull String name, int healthPoints, int defensePoints,
                    @NotNull BlockingQueue<ICharacter> turnsQueue, AbstractWeapon weapon) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
    }

    @Override
    public String getCharacterClass() {
        return "Engineer";
    }
}
