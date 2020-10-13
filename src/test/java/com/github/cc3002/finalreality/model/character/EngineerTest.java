package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerTest extends AbstractCharacterTest {

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        var expectedEngineer = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(expectedEngineer);
    }
    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        var testEngineer = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffEngineer = new Engineer("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedEngineer, testEngineer, diffEngineer, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Engineer";
        var character = new Engineer(CH_NAME, HPP, DFP, turns,
                null);
        assertEquals(characterClass, character.getCharacterClass());
    }
}
