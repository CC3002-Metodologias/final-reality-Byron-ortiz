package com.github.cc3002.finalreality.model.character.charactertests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.enemy.Enemy;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int ATK = 15;
  private static final int WEIGHT = 10;
  private Enemy testEnemy;
  @BeforeEach
  void setUp() {
    basicSetUp();
    testEnemy = new Enemy(ENEMY_NAME, WEIGHT,ATK, turns, DFP, HPP);
  }

  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(ENEMY_NAME, WEIGHT, ATK,turns, DFP, HPP);
    var diffEnemy = new Enemy("Pou", WEIGHT, ATK,turns, DFP, HPP);
    var differentClassCharacter = new Thief("LALO", 23,
            23, turns, testWeapons.get(3));
    assertEquals(expectedEnemy, testEnemy);
    assertNotEquals(expectedEnemy, diffEnemy);
    assertNotEquals(expectedEnemy, differentClassCharacter);
    assertEquals(expectedEnemy.hashCode(), testEnemy.hashCode());
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testEnemy.waitTurn();
    checkPutWait(testEnemy);
  }
}