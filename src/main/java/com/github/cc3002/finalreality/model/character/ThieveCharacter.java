package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a Thieve character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class ThieveCharacter extends AbstractPlayerCharacter {
    public ThieveCharacter(@NotNull String name, int healthPoints, int defensePoints,
                           @NotNull BlockingQueue<ICharacter> turnsQueue, Weapon weapon) {
        super(name, healthPoints, defensePoints, turnsQueue, weapon);
    }

    @Override
    public String getCharacterClass() {
        return "Thieve";
    }
}
