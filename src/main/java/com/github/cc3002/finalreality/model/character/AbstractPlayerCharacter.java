package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the playable characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter {

  /**
   * Creates a new abstract class to normal playable characters.
   *
   * @param name
   * the character's name
   * @param turnsQueue
   * the queue with the characters waiting for their turn
   * @param healthPoints
   * the health's character
   * @param defensePoints
   * the defensePoints of a character
   * @param equippedWeapon
   * character's equipped weapon
   */
  protected AbstractWeapon equippedWeapon = null;

  public AbstractPlayerCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue, AbstractWeapon weapon) {
    super(turnsQueue, name, healthPoints, defensePoints);
    this.equippedWeapon = weapon;
  }

  public abstract String getCharacterClass();

  public AbstractWeapon getEquippedWeapon() {
    return this.equippedWeapon;
  }

  public void equipWeapon(AbstractWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * puts the character waiting for they turn.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }


}


