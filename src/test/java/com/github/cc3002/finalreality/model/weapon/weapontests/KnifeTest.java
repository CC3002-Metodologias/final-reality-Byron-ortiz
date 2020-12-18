package com.github.cc3002.finalreality.model.weapon.weapontests;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Knife;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeTest extends AbstractWeaponTest {

    private Knife testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(WEAPON_NAME, WEIGHT, DAMAGE);
    }

    @Test
    void constructorTest() {
        var expectedWeapon = new Knife(WEAPON_NAME, WEIGHT, DAMAGE);
        var sameClassDifferentWeapon = new Knife(WEAPON_NAME, WEIGHT, 20);
        var differentClassWeapon = new Sword(WEAPON_NAME, WEIGHT, DAMAGE);
        super.checkConstructionTest(expectedWeapon, testKnife, sameClassDifferentWeapon,
                differentClassWeapon);
        assertEquals("Knife", testKnife.getType());
    }
}
