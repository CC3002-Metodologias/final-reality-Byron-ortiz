package com.github.cc3002.finalreality.model.character.charactertests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefTest extends AbstractCharacterTest {

    private Thief testThief;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testThief = new Thief(CH_NAME, HPP, DFP, turns, null);
    }
    @Test
    void constructorTest() {
        var expectedThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapons.get(2));
        var diffThief = new Thief("Sephirot", HPP, DFP, turns, testWeapons.get(2));
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapons.get(1));
        checkConstruction(expectedThief, testThief, diffThief, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Thief";
        assertEquals(characterClass, testThief.getCharacterClass());
    }

    @Test
    void waitTurnTest() {
        testThief.equipWeapon(testWeapons.get(2));
        Assertions.assertTrue(turns.isEmpty());
        testThief.waitTurn();
        checkPutWait(testThief);
    }

    @Test
    void equipWeaponTest() {
        int c = 0;
        for (IWeapon weapon : testWeapons) {
            testThief.equipWeapon(weapon);
            if (c==2 || c==3 || c==4) {
                assertEquals(testWeapons.get(c), testThief.getEquippedWeapon());
            }
            else {
                assertNull(testThief.getEquippedWeapon());
            }
            c++;
            testThief.setWeapon(null);
        }
        testThief.die();
        testThief.equipWeapon(testWeapons.get(2));
        assertNull(testThief.getEquippedWeapon());
    }
}
