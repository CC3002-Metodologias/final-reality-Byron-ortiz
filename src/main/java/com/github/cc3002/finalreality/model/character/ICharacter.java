package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.combathandlers.IEventHandler;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public interface ICharacter {

    /**
     * GETTERS, Returns the character's getAttribute.
     */
    String getName();
    int getHealthPoints();
    int getDamage();
    int getDefensePoints();
    boolean isAlive();
    int getWeight();
    String getCharacterClass();

    // ------------------------------------------------

    /**
     * Puts the character wait for its turn.
     */
    void waitTurn();
    /**
     * Adds a character to turns Queue.
     */
    void addToQueue();


    /**
     * methods to attack with double dispatch for more extensibility.
     */
    void attack(ICharacter defender);
    void receiveAttack(ICharacter attacker);

    // -------------------------------------------------------------------

    /**
     * a character dies, fire deathCharacter event.
     */
    void die();

    /**
     * Methods to manage the listeners, at moment to know when a character dies.
     */
    void addListener(IEventHandler handler);
    void cleanListeners(IEventHandler handler);


}