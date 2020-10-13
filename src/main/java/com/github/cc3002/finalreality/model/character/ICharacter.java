package com.github.cc3002.finalreality.model.character;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Byron Ortiz>
 */
public interface ICharacter {

    /**
     * Returns this character's name.
     */
    String getName();

    /**
     * Returns this character's HP.
     */
    int getHealthPoints();

    /**
     * Sets this character's HP.
     */
    void setHealthPoints(int healthPoints);

    /**
     * Method to wait for character's turn.
     */
    void waitTurn();

    /**
     * Method to access character's defense points.
     */
    int getDefensePoints();

    /**
     * Overrides equals method from object.
     */
    @Override
    boolean equals(Object o);

    /**
     * Adds a character to turns Queue.
     */
    void addToQueue();

     //
     // We should add some methods that every character should do like attack, etc.
     //

}