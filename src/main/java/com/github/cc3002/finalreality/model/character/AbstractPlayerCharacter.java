package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
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
  private IWeapon equippedWeapon = null;

  public AbstractPlayerCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue, IWeapon weapon) {
    super(turnsQueue, name, healthPoints, defensePoints);
    this.equippedWeapon = weapon;
  }
  /**
   * returns the character's type
   */
  public abstract String getCharacterClass();

  /**
   * returns the character's equippedWeapon
   */
  public IWeapon getEquippedWeapon() {
    return this.equippedWeapon;
  }

  /**
   * equips a weapon to some character (i think this method will change in the future
   * because of the limitations of every class character to equip weapons of
   * different types, but i dont know how to do it right now)
   */
  public void equipWeapon(IWeapon weapon) {
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


