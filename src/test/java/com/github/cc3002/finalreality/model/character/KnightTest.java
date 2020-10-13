package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest extends AbstractCharacterTest {
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        var expectedKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(expectedKnight);
    }
    @Test
    void constructorTest() {
        var expectedKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        var testKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffKnight = new Knight("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedKnight, testKnight, diffKnight, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Knight";
        var character = new Knight(CH_NAME, HPP, DFP, turns,
                null);
        assertEquals(characterClass, character.getCharacterClass());
    }
}
