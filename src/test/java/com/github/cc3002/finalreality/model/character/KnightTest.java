package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest extends AbstractCharacterTest {

    private Knight testKnight;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(testKnight);
    }
    @Test
    void constructorTest() {
        var expectedKnight = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffKnight = new Knight("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedKnight, testKnight, diffKnight, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Knight";
        assertEquals(characterClass, testKnight.getCharacterClass());
    }
}
