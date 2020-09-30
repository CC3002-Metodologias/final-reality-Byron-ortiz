package com.github.cc3002.finalreality.model.character;

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
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * returns the character's HP
   */
  @Override
  public int getHealthPoints() {
    return this.healthPoints;
  }

  /**
   * resets the character's HP
   */
  @Override
  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }
}
