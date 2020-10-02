package com.github.cc3002.finalreality.model.character;

<<<<<<< HEAD
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
=======
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

>>>>>>> origin/dev
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
<<<<<<< HEAD
 * @author <Your name>
=======
 * @author <Byron Ortiz>
>>>>>>> origin/dev
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
<<<<<<< HEAD
  protected final String name;
  private final CharacterClass characterClass;
  private Weapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }
=======
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
>>>>>>> origin/dev

  /**
   * Adds this character to the turns queue.
   */
<<<<<<< HEAD
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void equip(Weapon weapon) {
    if (this instanceof PlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }

  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
=======
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
>>>>>>> origin/dev
  }
}
