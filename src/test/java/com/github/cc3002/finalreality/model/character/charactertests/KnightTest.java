package com.github.cc3002.finalreality.model.character.charactertests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.playercharacter.Engineer;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightTest extends AbstractCharacterTest {

    private Knight testKnight;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testKnight = new Knight(CH_NAME, HPP, DFP, turns, null);
    }
    @Test
    void constructorTest() {
        var expectedKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapons.get(1));
        var diffKnight = new Knight("Sephirot", HPP, DFP, turns,
                testWeapons.get(1));
        var difClassCharacter = new Engineer(CH_NAME, HPP, DFP, turns,
                testWeapons.get(1));
        checkConstruction(expectedKnight, testKnight, diffKnight,
                difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Knight";
        assertEquals(characterClass, testKnight.getCharacterClass());
    }

    @Test
    void waitTurnTest() {
        testKnight.equipWeapon(testWeapons.get(1));
        Assertions.assertTrue(turns.isEmpty());
        testKnight.waitTurn();
        checkPutWait(testKnight);
    }

    @Test
    void equipWeaponTest() {
        int c = 0;
        for (IWeapon weapon : testWeapons) {
            testKnight.equipWeapon(weapon);
            if (c==1 || c==2 || c==3) {
                assertEquals(testWeapons.get(c), testKnight.getEquippedWeapon());
            }
            else {
                assertNull(testKnight.getEquippedWeapon());
            }
            c++;
            testKnight.setWeapon( null);
        }
        testKnight.die();
        testKnight.equipWeapon(testWeapons.get(1));
        assertNull(testKnight.getEquippedWeapon());
    }
}
