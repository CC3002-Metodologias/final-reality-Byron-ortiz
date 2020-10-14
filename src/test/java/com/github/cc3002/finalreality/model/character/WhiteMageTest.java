package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMageTest extends AbstractCharacterTest {

    private final int MANA = 22;
    private WhiteMage testWhiteMage;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        testCharacters.add(testWhiteMage);
    }
    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(CH_NAME, HPP, DFP, turns,
                testWeapon, MANA);
        var diffWhiteMage = new WhiteMage("Sephirot", HPP, DFP, turns,
                testWeapon, MANA);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
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
}
