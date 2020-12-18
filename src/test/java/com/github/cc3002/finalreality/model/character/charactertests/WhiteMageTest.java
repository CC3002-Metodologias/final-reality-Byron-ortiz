package com.github.cc3002.finalreality.model.character.charactertests;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WhiteMageTest extends AbstractCharacterTest {

    private final int MANA = 22;
    private WhiteMage testWhiteMage;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
    }
    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapons.get(0), MANA);
        var diffWhiteMage = new WhiteMage("Sephirot", HPP, DFP, turns,
                testWeapons.get(0), MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapons.get(1));
        checkConstruction(expectedWhiteMage, testWhiteMage, diffWhiteMage,
                difClassCharacter);
    }


    @Test
    void manaSetGetTest() {
        int setMana = 0;
        assertEquals(MANA, testWhiteMage.getMana());
        testWhiteMage.setMana(setMana);
        assertEquals(setMana, testWhiteMage.getMana());
    }
    @Test
    void getClassTest(){
        String characterClass = "White Mage";
        assertEquals(characterClass, testWhiteMage.getCharacterClass());
    }

    @Test
    void waitTurnTest() {
        testWhiteMage.equipWeapon(testWeapons.get(0));
        Assertions.assertTrue(turns.isEmpty());
        testWhiteMage.waitTurn();
        checkPutWait(testWhiteMage);
    }

    @Test
    void equipWeaponTest() {
        int c = 0;
        for (IWeapon weapon : testWeapons) {
            testWhiteMage.equipWeapon(weapon);
            if (c==0) {
                assertEquals(testWeapons.get(c), testWhiteMage.getEquippedWeapon());
            }
            else {
                assertNull(testWhiteMage.getEquippedWeapon());
            }
            c++;
            testWhiteMage.setWeapon(null);
        }
        testWhiteMage.die();
        testWhiteMage.equipWeapon(testWeapons.get(0));
        assertNull(testWhiteMage.getEquippedWeapon());
    }
}
