package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest extends AbstractWeaponTest {

    private Sword testSword;

    @BeforeEach
    void setUp() {
        testSword = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedWeapon = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
        var sameClassDifferentWeapon = new Sword(WEAPON_NAME, 15, DAMAGE);
        var differentClassWeapon = new Knife(WEAPON_NAME, WEIGHT, DAMAGE);
        super.checkConstructionTest(expectedWeapon, testSword, sameClassDifferentWeapon,
                differentClassWeapon);
        assertEquals("Sword", testSword.getType());
    }
}
