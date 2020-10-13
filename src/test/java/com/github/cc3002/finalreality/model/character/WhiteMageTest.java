package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMageTest extends AbstractCharacterTest {
    private final int MANA = 22;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        var expectedWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        testCharacters.add(expectedWhiteMage);
    }
    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var testWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var diffWhiteMage = new WhiteMage("Sephirot", HPP, DFP, turns,
                testWeapon, MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedWhiteMage, testWhiteMage, diffWhiteMage,
                difClassCharacter);
    }


    @Test
    void manaSetGetTest() {
        var character = new WhiteMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
        int setMana = 0;
        assertEquals(MANA, character.getMana());
        character.setMana(setMana);
        assertEquals(setMana, character.getMana());
    }
    @Test
    void getClassTest(){
        String characterClass = "White Mage";
        var character = new WhiteMage(CH_NAME, HPP, DFP, turns,
                null, MANA);
        assertEquals(characterClass, character.getCharacterClass());
    }
}
