package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.combathandlers.IEventHandler;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds the common behaviour of all game's characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class AbstractCharacter implements ICharacter {

    protected final BlockingQueue<ICharacter> turnsQueue;
    private final String name;
    public ScheduledExecutorService scheduledExecutor;
    private int healthPoints;
    private final int defensePoints;
    private boolean isAlive;
    private final PropertyChangeSupport characterDiedEvent = new PropertyChangeSupport(this);




    protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                @NotNull String name, int healthPoints, int defensePoints) {
        this.turnsQueue = turnsQueue;
        this.name = name;
        this.healthPoints = healthPoints;
        this.defensePoints = defensePoints;
        this.isAlive = true;
    }


    public void die() {
        characterDiedEvent.firePropertyChange("isAlive", true, false);
        turnsQueue.remove(this);
        isAlive = false;
    }

    @Override
    public void addToQueue() {
        turnsQueue.add(this);
        scheduledExecutor.shutdown();
    }
    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(this::addToQueue, getWeight() / 10, TimeUnit.SECONDS);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public int getDefensePoints() {
        return defensePoints;
    }

    @Override
    public void attack(ICharacter defender) {
        if (!defender.isAlive()) {
            System.out.println("Can not attack, " +
                    defender.getName() + " is out of combat");
            return;
        }
        else if (getDamage()==0) {
            System.out.println("Can not attack, " +
                    getName() + " need to equip a weapon");
            return;
        }
        defender.receiveAttack(this);
    }

    @Override
    public void receiveAttack(ICharacter attacker) {
        if (attacker.getDamage() - defensePoints >= healthPoints) {
            healthPoints = 0;
            die();
        }
        else if (attacker.getDamage()>defensePoints) {
            healthPoints -= (attacker.getDamage() - defensePoints);
        }
        else {
            return;
        }
    }

    public void addListener(IEventHandler handler) {
        characterDiedEvent.addPropertyChangeListener(handler);
    }

    @Override
    public void cleanListeners(IEventHandler handler) {
        characterDiedEvent.removePropertyChangeListener(handler);
    }

    @Override
    public String toString() {
        String out = "\n";
        out += getCharacterClass() + ", ";
        out += getName() + ":\n";
        out += "HP : " + Integer.toString(getHealthPoints()) + "\n";
        out += "DFP : " + Integer.toString(getDefensePoints()) + "\n";
        out += "ATK : " + Integer.toString(getDamage()) + "\n";
        out += "WEIGHT : " + Integer.toString(getWeight()) + "\n";
        return out;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        ICharacter that = (ICharacter) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}