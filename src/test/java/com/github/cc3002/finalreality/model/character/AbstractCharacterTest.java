package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.enemy.Enemy;
import com.github.cc3002.finalreality.model.character.playercharacter.Engineer;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.weapon.magicweapon.Wand;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.cc3002.finalreality.model.weapon.normalweapon.Bow;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Knife;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<IWeapon> testWeapons;
  protected static final String CH_NAME = "Cloud";
  protected int DFP = 2;
  protected int HPP = 20;
  protected int WEIGHT = 10;
  protected int DAMAGE = 12;
  protected int MAGIC_DAMAGE = 10;

  /**
   * Checks if putting a character waits an appropriate amount of time.
   */
  protected void checkPutWait(ICharacter testChar) {
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testChar, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  protected void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter sameClassDifferentCharacter,
                                   final ICharacter differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

  void checkAttack(ICharacter attacker, ICharacter defender) {
    attacker.attack(defender);
    assertEquals(10, defender.getHealthPoints());
    attacker.attack(defender);
    assertFalse(defender.isAlive());
    attacker.attack(defender);
    assertEquals(0, defender.getHealthPoints());

  }

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapons = new ArrayList<>();
    testWeapons.add(new Wand("testWand", WEIGHT, DAMAGE, MAGIC_DAMAGE));
    testWeapons.add(new Axe("testAxe", WEIGHT, DAMAGE));
    testWeapons.add(new Knife("testKnife", WEIGHT, DAMAGE));
    testWeapons.add(new Sword("testSword", WEIGHT, DAMAGE));
    testWeapons.add(new Bow("testBow", WEIGHT, DAMAGE));
  }

  //  on the below tests, could be any type of character
  @Test
  void hppGetTest() {
    var character = new Engineer(CH_NAME, HPP, DFP, turns,
            null);
    assertEquals(HPP, character.getHealthPoints());
  }


  // at moment isn't necessary to attack every class character, cause
  // there are not particular specification between them.
  void enemyAttackTest() {
    basicSetUp();
    var character1 = new Enemy("sephirot", 10, 14,
            turns, 10, 20);
    var character2 = new Engineer(CH_NAME, HPP, DFP, turns,
            null);
    checkAttack(character1, character2);
  }
  @Test
  void characterAttackTest() {
    basicSetUp();
    var character1 = new Enemy("sephirot", WEIGHT, 10,
            turns, DFP, HPP);
    var character2 = new Engineer(CH_NAME, HPP, DFP, turns,
            null);
    character2.attack(character1);
    assertEquals(20, character1.getHealthPoints());
    var character3 = new BlackMage(CH_NAME, HPP, 100, turns,
            testWeapons.get(0), 10);
    character1.attack(character3);
    assertEquals(20, character3.getHealthPoints());
    character2.equipWeapon(testWeapons.get(1));
    checkAttack(character2, character1);
  }

}