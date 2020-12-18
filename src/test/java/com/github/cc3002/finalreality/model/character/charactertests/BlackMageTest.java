package com.github.cc3002.finalreality.model.character.charactertests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BlackMageTest extends AbstractCharacterTest {
    private final int MANA = 22;
    private BlackMage testBlackMage;


    @BeforeEach
    void setUp() {
        basicSetUp();
        testBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                null, MANA);

    }
    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                testWeapons.get(0), MANA);
        var diffBlackMage = new BlackMage("Sephirot", HPP, DFP, turns,
                testWeapons.get(0), MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapons.get(0));
        checkConstruction(expectedBlackMage, testBlackMage, diffBlackMage,
                difClassCharacter);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        testBlackMage.equipWeapon(testWeapons.get(0));
        Assertions.assertTrue(turns.isEmpty());
        testBlackMage.waitTurn();
        checkPutWait(testBlackMage);
    }


    @Test
    void manaSetGetTest() {
        int setMana = 0;
        assertEquals(MANA, testBlackMage.getMana());
        testBlackMage.setMana(setMana);
        assertEquals(setMana, testBlackMage.getMana());
    }
    @Test
    void getClassTest(){
        String characterClass = "Black Mage";
        assertEquals(characterClass, testBlackMage.getCharacterClass());
    }
    @Test
    void equipWeaponTest() {
        int c = 0;
        for (IWeapon weapon : testWeapons) {
            testBlackMage.equipWeapon(weapon);
            if (c==0 || c==2) {
                assertEquals(testWeapons.get(c), testBlackMage.getEquippedWeapon());
            }
            else {
                assertNull(testBlackMage.getEquippedWeapon());
            }
            c++;
            testBlackMage.setWeapon( null);
        }
        testBlackMage.die();
        testBlackMage.equipWeapon(testWeapons.get(0));
        assertNull(testBlackMage.getEquippedWeapon());
    }
}
