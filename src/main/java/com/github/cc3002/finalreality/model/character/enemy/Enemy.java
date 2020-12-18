package com.github.cc3002.finalreality.model.character.enemy;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;
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

    @Override
    public int getDamage() {
        return this.attackPoints;
    }

    /**
     * Returns the weight of this enemy.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public String getCharacterClass() {
        return "Enemy";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemy)) {
            return false;
        }
        return super.equals(o);
    }

}