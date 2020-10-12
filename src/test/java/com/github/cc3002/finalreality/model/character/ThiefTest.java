package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefTest extends AbstractCharacterTest {
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        var expectedThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(expectedThief);
    }
    @Test
    void constructorTest() {
        var expectedThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapon);
        var testThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffThief = new Thief("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedThief, testThief, diffThief, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Thief";
        var character = new Thief(CH_NAME, HPP, DFP, turns,
                null);
        assertEquals(characterClass, character.getCharacterClass());
    }
}
