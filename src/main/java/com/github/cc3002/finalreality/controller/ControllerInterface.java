package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.character.enemy.Enemy;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.io.PrintStream;

public interface ControllerInterface {



    /**
     * Methods to create any character.
     *
     */
    IPCharacter createKnight(String name, int HP, int DFP, IWeapon weapon);
    IPCharacter createThief(String name, int HP, int DFP, IWeapon weapon);
    IPCharacter createEngineer(String name, int HP, int DFP, IWeapon weapon);
    IPCharacter createWhiteMage(String name, int HP, int DFP, IWeapon weapon, int MANA);
    IPCharacter createBlackMage(String name, int HP, int DFP, IWeapon weapon, int MANA);
    Enemy createEnemy(String name, int HP, int DFP, int ATK, int WEIGHT);
    // ---------------------------------------------------------


    /**
     * Methods to create weapons.
     *
     */
    IWeapon createAxe(String name, int weight, int damage);
    IWeapon createSword(String name, int weight, int damage);
    IWeapon createBow(String name, int weight, int damage);
    IWeapon createKnife(String name, int weight, int damage);
    IWeapon createWand(String name, int weight, int damage, int magicDamage);
    // -----------------------------------------------------------

    void equipWeapon(IWeapon weapon, IPCharacter character);
    void unEquipWeapon(IPCharacter character);

    void addToParty(ICharacter character);
    void partyInfo(PrintStream out);
    void enemyPartyInfo(PrintStream out);

    void addWeaponToInventory(IWeapon weapon);
    void removeWeaponFromInventory(IWeapon weapon);

    void attack(ICharacter attacker, ICharacter defender);
    void endTurn(ICharacter character);
    void beginTurn();

    void playerWon();
    void playerLoss();
}
