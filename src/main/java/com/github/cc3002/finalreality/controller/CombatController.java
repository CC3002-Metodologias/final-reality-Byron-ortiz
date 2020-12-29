package com.github.cc3002.finalreality.controller;


import com.github.cc3002.finalreality.controller.combathandlers.*;
import com.github.cc3002.finalreality.controller.combatphases.CombatEndedPhase;
import com.github.cc3002.finalreality.controller.combatphases.ICombatPhase;
import com.github.cc3002.finalreality.controller.combatphases.WaitActionState;
import com.github.cc3002.finalreality.controller.combatphases.WaitFillState;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.character.enemy.Enemy;
import com.github.cc3002.finalreality.model.character.playercharacter.Engineer;
import com.github.cc3002.finalreality.model.character.playercharacter.Knight;
import com.github.cc3002.finalreality.model.character.playercharacter.Thief;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.playercharacter.magecharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.magicweapon.Wand;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Axe;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Bow;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Knife;
import com.github.cc3002.finalreality.model.weapon.normalweapon.Sword;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.LinkedBlockingQueue;

public class CombatController implements ControllerInterface {

    private final BlockingQueue<ICharacter> turnsQueue;
    private List<ICharacter> party;
    private List<ICharacter> characters;
    private List<Enemy> enemyParty;
    private List<IWeapon> inventory;
    private IEventHandler deathPlayerHandler = new DeathPlayerHandler(this);
    private IEventHandler deathEnemyHandler = new DeathEnemyHandler(this);
    private IEventHandler changeTurnHandler = new ChangeTurnHandler(this);
    private IEventHandler readyToPlayHandler = new ReadyToPlayHandler(this);
    private final PropertyChangeSupport turnEvent = new PropertyChangeSupport(this);
    private ICharacter turnOwner;
    private int playerDeaths;
    private int enemyDeaths;
    private boolean win;
    private ICombatPhase phase;

    public CombatController() {
        this.turnsQueue = new LinkedBlockingQueue<>();
        this.party = new ArrayList<>(5);
        this.enemyParty = new ArrayList<>(5);
        this.inventory = new ArrayList<>();
        this.characters = new ArrayList<>();
        playerDeaths = 0;
        enemyDeaths = 0;
        turnEvent.addPropertyChangeListener(changeTurnHandler);
        setPhase(new WaitFillState());
    }

    public void setPhase(ICombatPhase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    public ICombatPhase getPhase() {
        return phase;
    }


    @Override
    public IPCharacter createKnight(String name, int HP, int DFP, IWeapon weapon) {
        IPCharacter character = new Knight(name, HP, DFP, turnsQueue, weapon);
        characters.add(character);
        return character;
    }

    @Override
    public IPCharacter createThief(String name, int HP, int DFP, IWeapon weapon) {
        IPCharacter character = new Thief(name, HP, DFP, turnsQueue, weapon);
        characters.add(character);
        return character;
    }

    @Override
    public IPCharacter createEngineer(String name, int HP, int DFP, IWeapon weapon) {
        IPCharacter character = new Engineer(name, HP, DFP, turnsQueue, weapon);
        characters.add(character);
        return character;
    }

    @Override
    public IPCharacter createWhiteMage(String name, int HP, int DFP, IWeapon weapon, int MANA) {
        IPCharacter character = new WhiteMage(name, HP, DFP, turnsQueue, weapon, MANA);
        characters.add(character);
        return character;
    }

    @Override
    public IPCharacter createBlackMage(String name, int HP, int DFP, IWeapon weapon, int MANA) {
        IPCharacter character = new BlackMage(name, HP, DFP, turnsQueue, weapon, MANA);
        characters.add(character);
        return character;
    }

    @Override
    public Enemy createEnemy(String name, int HP, int DFP, int ATK, int WEIGHT) {
        Enemy character = new Enemy(name, WEIGHT, ATK, turnsQueue, DFP, HP);
        character.addListenerDied(deathEnemyHandler);
        character.addListenerReady(readyToPlayHandler);
        enemyParty.add(character);
        characters.add(character);
        return character;
    }

    @Override
    public void addToParty(ICharacter character) {
        party.add(character);
        character.addListenerDied(deathPlayerHandler);
        character.addListenerReady(readyToPlayHandler);
    }

    @Override
    public Axe createAxe(String name, int weight, int damage) {
        Axe weapon = new Axe(name, weight, damage);
        return weapon;
    }
    @Override
    public Sword createSword(String name, int weight, int damage) {
        Sword weapon = new Sword(name, weight, damage);
        return weapon;
    }

    @Override
    public Bow createBow(String name, int weight, int damage) {
        Bow weapon = new Bow(name, weight, damage);
        return weapon;
    }

    @Override
    public Knife createKnife(String name, int weight, int damage) {
        Knife weapon = new Knife(name, weight, damage);
        return weapon;
    }

    @Override
    public Wand createWand(String name, int weight, int damage, int magicDamage) {
        Wand weapon = new Wand(name, weight, damage, magicDamage);
        return weapon;
    }



    @Override
    public void equipWeapon(IWeapon weapon, IPCharacter character) {
        unEquipWeapon(character);
        character.equipWeapon(weapon);
        removeWeaponFromInventory(weapon);
    }

    @Override
    public void unEquipWeapon(IPCharacter character) {
        if (character.hasWeapon()) {
            IWeapon current_weapon = character.getEquippedWeapon();
            character.setNullWeapon();
            addWeaponToInventory(current_weapon);
        }
    }


    @Override
    public void partyInfo(PrintStream out) {
        party.forEach(character -> out.println(character.toString()));
    }

    @Override
    public void enemyPartyInfo(PrintStream out) {
        enemyParty.forEach(character -> out.println(character.toString()));
    }

    @Override
    public void addWeaponToInventory(IWeapon weapon) {
        inventory.add(weapon);
    }

    @Override
    public void removeWeaponFromInventory(IWeapon weapon) {
        inventory.remove(weapon);
    }

    @Override
    public void attack(ICharacter attacker, ICharacter defender) {
        attacker.attack(defender);
        endTurn(attacker);
    }


    public void putAllToWait() {
        characters.forEach(ICharacter::waitTurn);
    }

    @Override
    public void endTurn(ICharacter character) {
        turnEvent.firePropertyChange("end", character, null);
        character.waitTurn();
    }


    @Override
    public void beginTurn() {
        if (!turnsQueue.isEmpty()) {
            turnOwner = turnsQueue.poll();
            turnEvent.firePropertyChange("begin", null, turnOwner);
        }
        else {
            setPhase( new WaitFillState());
        }
    }

    public ICharacter getTurnOwner() {
        return turnOwner;
    }

    public void turnEnded(ICharacter character) {
        System.out.println( character.getName()+ " end his turn\n");
        beginTurn();
    }
    public void turnBegan(ICharacter character) {
        System.out.println(character.getName()+ " began his turn\n");
        setPhase(new WaitActionState());
    }

    public void countPlayerDeath() {
        playerDeaths+=1;
        if (playerDeaths==party.size()) {
            playerLoss();
        }
    }

    public void countEnemyDeath() {
        enemyDeaths+=1;
        if (enemyDeaths==enemyParty.size()) {
            playerWon();
        }
    }

    @Override
    public void playerWon() {
        win = true;
        cleanListeners();
        turnsQueue.clear();
        System.out.println("You Win\n");
        setPhase(new CombatEndedPhase());
    }

    public void cleanListeners() {
        turnEvent.removePropertyChangeListener(changeTurnHandler);
        party.forEach(character -> {
            character.cleanListenerDied(deathPlayerHandler);
            character.cleanListenerReady(readyToPlayHandler);
        });
        enemyParty.forEach(character -> {
            character.cleanListenerDied(deathEnemyHandler);
            character.cleanListenerReady(readyToPlayHandler);
        });
    }

    @Override
    public void playerLoss() {
        win = false;
        cleanListeners();
        turnsQueue.clear();
        System.out.println("You Lose\n");
        setPhase(new CombatEndedPhase());
    }

    public boolean getWin() {
        return win;
    }

    public List<ICharacter> getCharacters() {
        return characters;
    }

    public List<Enemy> getEnemyParty() {
        return enemyParty;
    }

    public List<ICharacter> getParty() {
        return party;
    }

    public List<IWeapon> getInventory() {
        return inventory;
    }
}
