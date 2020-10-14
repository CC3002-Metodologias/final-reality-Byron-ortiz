package com.github.cc3002.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerTest extends AbstractCharacterTest {

    private Engineer testEngineer;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
         testEngineer = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        testCharacters.add(testEngineer);
    }
    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(CH_NAME, HPP, DFP, turns, testWeapon);
        var diffEngineer = new Engineer("Sephirot", HPP, DFP, turns, testWeapon);
        var difClassCharacter = new Knight(CH_NAME, HPP, DFP, turns, testWeapon);
        checkConstruction(expectedEngineer, testEngineer, diffEngineer, difClassCharacter);
    }

    @Test
    void getClassTest(){
        String characterClass = "Engineer";
        assertEquals(characterClass, testEngineer.getCharacterClass());
    }
}
