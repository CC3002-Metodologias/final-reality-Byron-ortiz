package com.github.cc3002.finalreality.model.character;

<<<<<<< HEAD
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;

=======
>>>>>>> origin/dev
/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
<<<<<<< HEAD
 * @author <Your name>
=======
 * @author <Byron Ortiz>
>>>>>>> origin/dev
 */
public interface ICharacter {

  /**
<<<<<<< HEAD
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
=======
>>>>>>> origin/dev
   * Returns this character's name.
   */
  String getName();

<<<<<<< HEAD
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();
=======

  /**
   * Returns this character's HP.
   */
  public int getHealthPoints();
  /**
   * Sets this character's HP.
   */
  void setHealthPoints(int healthPoints);
  /**
   * Method to wait for character's turn.
   */
  public void waitTurn();
  /**
   * We should add some methods that every character should do like  atk, walk, etc.
   */

>>>>>>> origin/dev
}
