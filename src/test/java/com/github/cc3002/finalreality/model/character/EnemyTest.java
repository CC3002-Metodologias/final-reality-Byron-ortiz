package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int ATK = 15;
  private static final int WEIGHT = 10;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testChar.add(new Enemy(ENEMY_NAME, WEIGHT,ATK, turns, DFP, HPP));
  }

  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(ENEMY_NAME, WEIGHT, ATK,turns, DFP, HPP);
    var diffEnemy0 = new Enemy("Pou", WEIGHT, ATK,turns, DFP, HPP);
    var diffEnemy1 = new Enemy(ENEMY_NAME, 23, ATK,turns, DFP, HPP);
    var diffEnemy2 = new Enemy(ENEMY_NAME, WEIGHT, 23,turns, DFP, HPP);
    var diffEnemy3 = new Enemy(ENEMY_NAME, WEIGHT, ATK,turns, 123, HPP);
    var diffEnemy4 = new Enemy(ENEMY_NAME, WEIGHT, ATK,turns, DFP, 1);
    var differentClassCharacter = new Thief("LALO", 23,
            23, turns, testWeapon);
    assertEquals(expectedEnemy, testChar.get(0));
    assertNotEquals(expectedEnemy, diffEnemy0);
    assertNotEquals(expectedEnemy, differentClassCharacter);
    assertEquals(expectedEnemy.hashCode(), testChar.get(0).hashCode());
    assertNotEquals(expectedEnemy, diffEnemy1);
    assertNotEquals(expectedEnemy, diffEnemy2);
    assertNotEquals(expectedEnemy, diffEnemy3);
    assertNotEquals(expectedEnemy, diffEnemy4);


  }
}