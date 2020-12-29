package com.github.cc3002.finalreality.controller.combatphases;

import com.github.cc3002.finalreality.controller.CombatController;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface ICombatPhase {


    void setController(CombatController combatController);
    void selectWeapon(IWeapon weapon);
    void selectCharacter(ICharacter character);
    void attack(ICharacter attacker, ICharacter defender);
    void equipWeapon(IWeapon weapon, IPCharacter character);
    void selectAttackAction();
    void selectReturn();
    void selectWeaponAction();

}
