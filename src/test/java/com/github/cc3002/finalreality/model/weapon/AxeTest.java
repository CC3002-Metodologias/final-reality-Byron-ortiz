package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest extends AbstractWeaponTest {

    private Axe testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(WEAPON_NAME, WEIGHT, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedWeapon = new Axe(WEAPON_NAME, WEIGHT, DAMAGE);
        var sameClassDifferentWeapon = new Axe(WEAPON_NAME, WEIGHT, 20);
        var differentClassWeapon = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
        super.checkConstructionTest(expectedWeapon, testAxe, sameClassDifferentWeapon,
                differentClassWeapon);
        assertEquals("Axe", testAxe.getType());
    }
}
