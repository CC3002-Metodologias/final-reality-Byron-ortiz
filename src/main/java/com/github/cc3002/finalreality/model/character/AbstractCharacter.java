package com.github.cc3002.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

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

    protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                @NotNull String name, int healthPoints, int defensePoints) {
        this.turnsQueue = turnsQueue;
        this.name = name;
        this.healthPoints = healthPoints;
        this.defensePoints = defensePoints;
    }

    @Override
    public abstract void waitTurn();


    @Override
    public void addToQueue() {
        turnsQueue.add(this);
        scheduledExecutor.shutdown();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


    @Override
    public int getDefensePoints() {
        return defensePoints;
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