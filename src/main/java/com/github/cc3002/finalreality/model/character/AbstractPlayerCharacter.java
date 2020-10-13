package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds the common behaviour of all the playable characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPCharacter {

    private IWeapon equippedWeapon;

    public AbstractPlayerCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                   @NotNull BlockingQueue<ICharacter> turnsQueue, IWeapon weapon) {
        super(turnsQueue, name, healthPoints, defensePoints);
        this.equippedWeapon = weapon;
    }

    /**
     * Returns the character's type.
     */
    public abstract String getCharacterClass();

    /**
     * Returns the character's equippedWeapon
     */
    @Override
    public IWeapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    /**
     * Equips a weapon to some character.
     */
    public void equipWeapon(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    /**
     * Puts the character waiting for they turn.
     */
    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }
}


