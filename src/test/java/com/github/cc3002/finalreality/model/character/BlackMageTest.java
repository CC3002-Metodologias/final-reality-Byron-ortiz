package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BlackMageTest extends AbstractCharacterTest {
    private final int MANA = 22;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        var expectedBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        testCharacters.add(expectedBlackMage);
    }
    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var testBlackMage = new BlackMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var diffBlackMage = new BlackMage("Sephirot", HPP, DFP, turns,
                testWeapon, MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedBlackMage, testBlackMage, diffBlackMage,
                difClassCharacter);
    }


    @Test
    void manaSetGetTest() {
        var character = new BlackMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
        int setMana = 0;
        assertEquals(MANA, character.getMana());
        character.setMana(setMana);
        assertEquals(setMana, character.getMana());
    }
    @Test
    void getClassTest(){
        String characterClass = "Black Mage";
        var character = new BlackMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
        assertEquals(characterClass, character.getCharacterClass());
    }
}
