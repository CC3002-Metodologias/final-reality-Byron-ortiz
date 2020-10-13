package com.github.cc3002.finalreality.model.character;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Byron Ortiz>
 */
public class Enemy extends AbstractCharacter {

    private final int weight;
    private final int attackPoints;

    /**
     * Creates a new enemy with a name, a weight and the queue with the characters ready to
     * play.
     */
    public Enemy(@NotNull final String name, final int weight, final int attackPoints,
                 @NotNull final BlockingQueue<ICharacter> turnsQueue, int defensePoints, int healthPoints) {
        super(turnsQueue, name, healthPoints, defensePoints);
        this.weight = weight;
        this.attackPoints = attackPoints;
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
    }

    /**
     * Returns the character's ATK points.
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Returns the weight of this enemy.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemy)) {
            return false;
        }
        Enemy that = (Enemy) o;
        return super.equals(o) &&
                getWeight() == that.getWeight() &&
                getDefensePoints() == that.getDefensePoints() &&
                getHealthPoints() == that.getHealthPoints() &&
                getAttackPoints() == that.getAttackPoints();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDefensePoints(), getHealthPoints(),
                getAttackPoints());
    }
}