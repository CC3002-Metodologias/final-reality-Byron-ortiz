package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefTest extends AbstractCharacterTest {

    private Thief testThief;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(testThief);
    }
    @Test
    void constructorTest() {
        var expectedThief = new Thief(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffThief = new Thief("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedThief, testThief, diffThief, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Thief";
        assertEquals(characterClass, testThief.getCharacterClass());
    }
}
