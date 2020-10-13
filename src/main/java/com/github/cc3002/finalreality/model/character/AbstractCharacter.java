package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  private final String name;
  private int healthPoints;
  private int defensePoints;
  public ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, int healthPoints, int defensePoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.healthPoints = healthPoints;
    this.defensePoints = defensePoints;
  }
  /**
   * abstract method to wait for character's turn
   */
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   */

  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  public String getName() {
    return this.name;
  }

  /**
   * returns the character's HP
   */
  public int getHealthPoints() {
    return this.healthPoints;
  }


  /**
   * resets the character's HP
   */
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