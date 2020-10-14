package com.github.cc3002.finalreality.model.weapon;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class AbstractWeaponTest {

    protected  int DAMAGE = 15;
    protected  int WEIGHT = 10;
    protected String WEAPON_NAME = "testWeapon";


    protected void checkConstructionTest(final IWeapon expectedWeapon,
                                         final IWeapon testWeapon,
                                         final IWeapon sameClassDifferentWeapon,
                                         final IWeapon differentClassWeapon) {
        assertEquals(expectedWeapon, testWeapon);
        assertNotEquals(expectedWeapon, differentClassWeapon);
        assertNotEquals(expectedWeapon, sameClassDifferentWeapon);
        assertEquals(expectedWeapon.hashCode(), testWeapon.hashCode());
    }

}
