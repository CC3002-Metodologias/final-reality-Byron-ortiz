package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;
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
  protected Weapon equippedWeapon = null;

  public AbstractPlayerCharacter(@NotNull String name, int healthPoints, int defensePoints,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue, Weapon weapon) {
    super(turnsQueue, name, healthPoints, defensePoints);
    this.equippedWeapon = weapon;
  }

  public abstract String getCharacterClass();

  public Weapon getEquippedWeapon() {
    return this.equippedWeapon;
  }

  public void equipWeapon(Weapon weapon) {
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


