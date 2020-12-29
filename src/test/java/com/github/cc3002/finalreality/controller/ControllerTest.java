package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.combatphases.CombatEndedPhase;
import com.github.cc3002.finalreality.controller.combatphases.WaitActionState;
import com.github.cc3002.finalreality.controller.combatphases.WaitFillState;
import com.github.cc3002.finalreality.model.character.ICharacter;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private static final int MANA = 15;
    private CombatController controller;
    private final String NAME = "cloud";
    private final int HP_PLAYER = 20;
    private final int DP_PLAYER = 15;
    private final int DAMAGE = 25;
    private final int WEIGHT = 25;
    private BlockingQueue<ICharacter> turns;

    @BeforeEach
    public void setUp() {
        controller = new CombatController();
    }

    @Test
    public void checkCharacterCreationTest() {
        controller.createKnight(NAME, HP_PLAYER, DP_PLAYER, null);
        controller.createEngineer(NAME, HP_PLAYER, DP_PLAYER, null);
        controller.createThief(NAME, HP_PLAYER, DP_PLAYER, null);
        controller.createBlackMage(NAME, HP_PLAYER, DP_PLAYER, null, MANA);
        controller.createWhiteMage(NAME, HP_PLAYER, DP_PLAYER, null, MANA);
        controller.createEnemy(NAME, HP_PLAYER, DP_PLAYER, 10, 10);
        assertEquals(new Knight(NAME, HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(0));
        assertNotEquals(new Knight("volg", HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(0));
        assertEquals(new Engineer(NAME, HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(1));
        assertNotEquals(new Engineer("volg", HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(1));
        assertEquals(new Thief(NAME, HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(2));
        assertNotEquals(new Thief("volg", HP_PLAYER, DP_PLAYER, turns, null),
                controller.getCharacters().get(2));
        assertEquals(new BlackMage(NAME, HP_PLAYER, DP_PLAYER, turns, null, MANA),
                controller.getCharacters().get(3));
        assertNotEquals(new BlackMage("volg", HP_PLAYER, DP_PLAYER, turns, null, MANA),
                controller.getCharacters().get(3));
        assertEquals(new WhiteMage(NAME, HP_PLAYER, DP_PLAYER, turns, null, MANA),
                controller.getCharacters().get(4));
        assertNotEquals(new WhiteMage("volg", HP_PLAYER, DP_PLAYER, turns, null, MANA),
                controller.getCharacters().get(4));
        assertEquals(new Enemy(NAME, 10, 10, turns, DP_PLAYER, HP_PLAYER),
                controller.getCharacters().get(5));
        assertNotEquals(new Enemy("volg", 10, 10, turns, DP_PLAYER, HP_PLAYER),
                controller.getCharacters().get(5));
    }

    @Test
    public void checkWeaponCreationTest() {
        IWeapon axe = controller.createAxe(NAME, WEIGHT, DAMAGE);
        IWeapon knife = controller.createKnife(NAME, WEIGHT, DAMAGE);
        IWeapon sword = controller.createSword(NAME, WEIGHT, DAMAGE);
        IWeapon bow = controller.createBow(NAME, WEIGHT, DAMAGE);
        IWeapon wand = controller.createWand(NAME, WEIGHT, DAMAGE, 50);
        assertEquals(new Axe(NAME, WEIGHT, DAMAGE), axe);
        assertNotEquals(new Axe("stick", WEIGHT, DAMAGE), axe);
        assertEquals(new Knife(NAME, WEIGHT, DAMAGE), knife);
        assertNotEquals(new Knife("stick", WEIGHT, DAMAGE), knife);
        assertEquals(new Sword(NAME, WEIGHT, DAMAGE), sword);
        assertNotEquals(new Sword("stick", WEIGHT, DAMAGE), sword);
        assertEquals(new Bow(NAME, WEIGHT, DAMAGE), bow);
        assertNotEquals(new Bow("stick", WEIGHT, DAMAGE), bow);
        assertEquals(new Wand(NAME, WEIGHT, DAMAGE, 50), wand);
        assertNotEquals(new Wand("stick", WEIGHT, DAMAGE, 50), wand);
    }


    @Test
    public void checkEquipUnEquip() {
        var character = controller.createKnight(NAME, HP_PLAYER, DP_PLAYER, null);
        IWeapon axe = controller.createAxe(NAME, WEIGHT, DAMAGE);
        IWeapon sword = controller.createSword(NAME, WEIGHT, DAMAGE);
        controller.equipWeapon(axe, character);
        assertEquals(axe, character.getEquippedWeapon());
        controller.unEquipWeapon(character);
        assertEquals(axe, controller.getInventory().get(0));
        assertNull(character.getEquippedWeapon());
        controller.equipWeapon(axe, character);
        controller.equipWeapon(sword, character);
        assertEquals(sword, character.getEquippedWeapon());
        assertEquals(1, controller.getInventory().size());    // check the right inventory size
    }

    @Test
    public void checkCombat() throws InterruptedException {
        IWeapon axe = controller.createAxe("knight_weapon", 10, DAMAGE);
        IWeapon bow = controller.createBow("Engineer_weapon", 20, 35);
        IWeapon sword = controller.createSword("thief_weapon", 30, 35);
        IWeapon knife = controller.createKnife("bm_weapon", 40, 35);
        IWeapon wand = controller.createWand("wm_weapon", 50, 35, 50);
        var knight = controller.createKnight("character1", HP_PLAYER, DP_PLAYER, axe);
        var engineer = controller.createEngineer("character2", HP_PLAYER, DP_PLAYER, bow);
        var thief = controller.createThief("character3", HP_PLAYER, DP_PLAYER, sword);
        var blackMage = controller.createBlackMage("character4", HP_PLAYER, DP_PLAYER, knife, MANA);
        var whiteMage = controller.createWhiteMage("character5", HP_PLAYER, DP_PLAYER, wand, MANA);
        controller.addToParty(knight);
        controller.addToParty(engineer);
        controller.addToParty(thief);
        controller.addToParty(blackMage);
        controller.addToParty(whiteMage);
        controller.createEnemy("enemy1", HP_PLAYER, DP_PLAYER, 10, 60);
        controller.createEnemy("enemy2", HP_PLAYER, DP_PLAYER, 10, 60);
        controller.createEnemy("enemy3", HP_PLAYER, DP_PLAYER, 10, 60);
        controller.createEnemy("enemy4", HP_PLAYER, DP_PLAYER, 10, 60);
        controller.createEnemy("enemy5", HP_PLAYER, DP_PLAYER, 10, 60);
        controller.putAllToWait();
        Thread.sleep(20000);
        assertEquals(knight, controller.getTurnOwner());
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(0));
        assertEquals(10, controller.getEnemyParty().get(0).getHealthPoints());
        assertEquals(engineer, controller.getTurnOwner());
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(0));
        assertFalse(controller.getEnemyParty().get(0).isAlive());
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(1));
        assertFalse(controller.getEnemyParty().get(1).isAlive());
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(2));
        assertFalse(controller.getEnemyParty().get(2).isAlive());
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(3));
        assertFalse(controller.getEnemyParty().get(3).isAlive());
        Thread.sleep(15000);
        controller.attack(controller.getTurnOwner(), controller.getParty().get(0));
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(4));
        controller.attack(controller.getTurnOwner(), controller.getEnemyParty().get(4));
        assertTrue(controller.getWin());
        var endPhase = new CombatEndedPhase();
        endPhase.setController(controller);
        assertEquals(endPhase, controller.getPhase());
    }

    @Test
    public void checkCombatAndPhase() throws InterruptedException {
        IWeapon axe = controller.createAxe("knight_weapon", 10, DAMAGE);
        IWeapon bow = controller.createBow("Engineer_weapon", 20, 35);
        var knight = controller.createKnight("character1", HP_PLAYER, DP_PLAYER, axe);
        var engineer = controller.createEngineer("character2", HP_PLAYER, DP_PLAYER, bow);
        var endPhase = new CombatEndedPhase();
        var waitFillPhase = new WaitFillState();
        var waitActionPhase = new WaitActionState();
        endPhase.setController(controller);
        waitFillPhase.setController(controller);
        waitActionPhase.setController(controller);
        controller.addToParty(knight);
        controller.addToParty(engineer);
        controller.createEnemy("enemy1", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy2", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy3", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy4", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy5", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.putAllToWait();
        assertEquals(waitFillPhase, controller.getPhase());
        Thread.sleep(4000);
        controller.attack(controller.getTurnOwner(), controller.getParty().get(0));
        assertEquals(waitActionPhase, controller.getPhase());
        controller.attack(controller.getTurnOwner(), controller.getParty().get(0));
        controller.attack(controller.getTurnOwner(), controller.getParty().get(1));
        controller.attack(controller.getTurnOwner(), controller.getParty().get(1));
        assertFalse(controller.getWin());
        assertEquals(endPhase, controller.getPhase());
    }

    @Test
    public void showToString(){
        IWeapon axe = controller.createAxe("knight_weapon", 10, DAMAGE);
        IWeapon bow = controller.createBow("Engineer_weapon", 20, 35);
        IWeapon wand = controller.createWand("wm_weapon", 50, 35, 50);
        var knight = controller.createKnight("character1", HP_PLAYER, DP_PLAYER, axe);
        var engineer = controller.createEngineer("character2", HP_PLAYER, DP_PLAYER, bow);
        var whiteMage = controller.createWhiteMage("character3", HP_PLAYER, DP_PLAYER, wand, MANA);

        controller.addToParty(knight);
        controller.addToParty(engineer);
        controller.addToParty(whiteMage);
        controller.createEnemy("enemy1", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy2", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy3", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy4", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.createEnemy("enemy5", HP_PLAYER, DP_PLAYER, 30, 5);
        controller.partyInfo(System.out);
        controller.enemyPartyInfo(System.out);
    }




}
