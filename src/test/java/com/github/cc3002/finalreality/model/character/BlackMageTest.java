package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BlackMageTest extends AbstractCharacterTest {
    private final int MANA = 22;
    private BlackMage testBlackMage;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
        testCharacters.add(testBlackMage);
    }
    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var diffBlackMage = new BlackMage("Sephirot", HPP, DFP, turns,
                testWeapon, MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedBlackMage, testBlackMage, diffBlackMage,
                difClassCharacter);
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
}
