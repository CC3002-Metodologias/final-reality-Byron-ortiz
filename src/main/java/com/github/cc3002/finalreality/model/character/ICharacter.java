package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public interface ICharacter {

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue();

  /**
   * Returns this character's HP.
   */
  public int getHealthPoints();
  /**
   * Sets this character's HP.
   */
  void setHealthPoints(int healthPoints);
}
