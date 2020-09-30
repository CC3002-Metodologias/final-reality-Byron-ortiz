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
  protected final String name;
  protected int healthPoints;
  protected int defensePoints;
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
  protected void addToQueue() {
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
}
