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

public class EngineerTest extends AbstractCharacterTest {

    private Engineer testEngineer;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
         testEngineer = new Engineer(CH_NAME, HPP, DFP, turns, null);
    }
    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(CH_NAME, HPP, DFP, turns, null);
        var diffEngineer = new Engineer("Sephirot", HPP, DFP, turns,
                testWeapons.get(1));
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns,
                testWeapons.get(1));
        checkConstruction(expectedEngineer, testEngineer, diffEngineer,
                difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Engineer";
        assertEquals(characterClass, testEngineer.getCharacterClass());
    }

    @Test
    void waitTurnTest() {
        testEngineer.equipWeapon(testWeapons.get(1));
        Assertions.assertTrue(turns.isEmpty());
        testEngineer.waitTurn();
        checkPutWait(testEngineer);
    }

    @Test
    void equipWeaponTest() {
        int c = 0;
        for (IWeapon weapon : testWeapons) {
            testEngineer.equipWeapon(weapon);
            if (c==1 || c==4) {
                assertEquals(testWeapons.get(c), testEngineer.getEquippedWeapon());
            }
            else {
                assertNull(testEngineer.getEquippedWeapon());
            }
            c++;
            testEngineer.setWeapon( null);
        }
        testEngineer.die();
        testEngineer.equipWeapon(testWeapons.get(0));
        assertNull(testEngineer.getEquippedWeapon());
    }
}
