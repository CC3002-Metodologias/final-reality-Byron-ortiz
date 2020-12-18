package com.github.cc3002.finalreality.model.weapon.weapontests;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Bow;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowTest extends AbstractWeaponTest {

    private Bow testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(WEAPON_NAME, WEIGHT, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedWeapon = new Bow(WEAPON_NAME, WEIGHT, DAMAGE);
        var sameClassDifferentWeapon = new Bow("Different bow", WEIGHT, DAMAGE);
        var differentClassWeapon = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
        super.checkConstructionTest(expectedWeapon, testBow, sameClassDifferentWeapon,
                differentClassWeapon);
        assertEquals("Bow", testBow.getType());
    }
}
