package com.github.cc3002.finalreality.model.weapon.weapontests;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.cc3002.finalreality.model.weapon.magicweapon.Wand;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WandTest extends AbstractWeaponTest {

    private Wand testWand;
    private final int MAGICDAMAGE = 20;

    @BeforeEach
    void setUp() {
        testWand = new Wand(WEAPON_NAME, WEIGHT, DAMAGE, MAGICDAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedWeapon = new Wand(WEAPON_NAME, WEIGHT, DAMAGE, MAGICDAMAGE);
        var sameClassDifferentWeapon = new Wand(WEAPON_NAME, WEIGHT, DAMAGE, 13);
        var differentClassWeapon = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
        super.checkConstructionTest(expectedWeapon, testWand, sameClassDifferentWeapon,
                differentClassWeapon);
        var differentWand = new Wand(WEAPON_NAME, 13, DAMAGE, MAGICDAMAGE);
        assertNotEquals(expectedWeapon, differentWand);
        assertEquals("Wand", testWand.getType());
    }
}
