package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
<<<<<<< HEAD
=======
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

>>>>>>> origin/dev
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
<<<<<<< HEAD
 * @author <Your name>
=======
 * @author <Byron Ortiz>
>>>>>>> origin/dev
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
<<<<<<< HEAD
=======
  private final int attackPoints;
>>>>>>> origin/dev

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
<<<<<<< HEAD
  public Enemy(@NotNull final String name, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, CharacterClass.ENEMY);
    this.weight = weight;
=======
  public Enemy(@NotNull final String name, final int weight, final int attackPoints,
      @NotNull final BlockingQueue<ICharacter> turnsQueue, int defensePoints, int healthPoints) {
    super(turnsQueue, name, healthPoints,defensePoints);
    this.weight = weight;
    this.attackPoints = attackPoints;
  }
  /**
   * puts the character waiting for they turn.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
>>>>>>> origin/dev
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }
<<<<<<< HEAD

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
=======
>>>>>>> origin/dev
}
