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

    @Override
    public abstract String getCharacterClass();

    @Override
    public IWeapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    @Override
    public int getDamage() {
        if (getEquippedWeapon()!=null) {
            return getEquippedWeapon().getDamage();
        }
        return 0;
    }

    @Override
    public int getWeight() {
        return equippedWeapon.getWeight();
    }

    public void setWeapon(IWeapon weapon) {
        if (isAlive()) {
            equippedWeapon = weapon;
        }
        else {
            System.out.println(getName() + " is out of combat" +
                    ", can not equip weapon ");
        }
    }
    public void setNullWeapon() {
        equippedWeapon = null;
    }

    @Override
    public boolean hasWeapon() {
        if (equippedWeapon!=null) {
            return true;
        }
        return false;
    }

}


