package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//import com.sun.javafx.scene.traversal.WeightedClosestCorner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String WAND_NAME = "Test Wand";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int MAGIC_DAMAGE = 20;
  private static final int WEIGHT = 10;


  private Axe  testAxe;
  private Wand testWand;
  private Sword testSword;
  private Bow testBow;
  private Knife testKnife;

  @BeforeEach
  void setUp() {
      testAxe = new Axe(AXE_NAME, WEIGHT, DAMAGE);
      testSword = new Sword(SWORD_NAME, WEIGHT, DAMAGE);
      testBow = new Bow(BOW_NAME, WEIGHT, DAMAGE);
      testKnife = new Knife(KNIFE_NAME, WEIGHT, DAMAGE);
      testWand = new Wand(WAND_NAME, WEIGHT, DAMAGE, MAGIC_DAMAGE);
  }


  @Test
  void constructorTest() {
      var expectedAxe = new Axe(AXE_NAME, WEIGHT, DAMAGE);
      var expectedSword = new Sword(SWORD_NAME, WEIGHT, DAMAGE);
      var expectedBow = new Bow(BOW_NAME, WEIGHT, DAMAGE);
      var expectedKnife = new Knife(KNIFE_NAME, WEIGHT, DAMAGE);
      var expectedWand = new Wand(WAND_NAME, WEIGHT, DAMAGE, MAGIC_DAMAGE);
      var differentWand = new Wand(WAND_NAME, WEIGHT,
              DAMAGE, MAGIC_DAMAGE +1);
    var differentWand2 = new Wand("DIFFERENT_WAND", WEIGHT,
            DAMAGE, MAGIC_DAMAGE);

    assertEquals(expectedAxe, testAxe);
    assertNotEquals(expectedAxe, testSword);
    assertNotEquals(expectedAxe, new Axe(AXE_NAME, WEIGHT, 22));
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals("Axe", testAxe.getType());
    assertEquals(expectedWand, testWand);
    assertNotEquals(expectedWand, testSword);
    assertNotEquals(expectedWand, differentWand);
    assertNotEquals(expectedWand, differentWand2);
    assertEquals(expectedWand.hashCode(), testWand.hashCode());
    assertNotEquals(expectedWand.hashCode(), differentWand.hashCode());
    assertEquals("Wand", testWand.getType());
    assertEquals(expectedSword, testSword);
    assertNotEquals(expectedSword, testAxe);
    assertNotEquals(expectedSword, new Sword("Different_Sword", WEIGHT, DAMAGE));
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals("Sword", testSword.getType());
    assertEquals(expectedBow, testBow);
    assertNotEquals(expectedBow, testSword);
    assertNotEquals(expectedBow, new Bow("Different_Bow", 23, 22));
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals("Bow", testBow.getType());
    assertEquals(expectedKnife, testKnife);
    assertNotEquals(expectedKnife, testSword);
    assertNotEquals(expectedKnife, new Knife("Different_Knife", 23, 22));
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertEquals("Knife", testKnife.getType());
  }
}