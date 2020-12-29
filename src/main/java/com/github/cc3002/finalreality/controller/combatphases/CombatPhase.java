package com.github.cc3002.finalreality.controller.combatphases;

import com.github.cc3002.finalreality.controller.CombatController;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.Objects;

public class CombatPhase implements ICombatPhase {

    protected CombatController controller;

    public CombatPhase() {
        this.controller = null;
    }

    public void setController(CombatController controller){
        this.controller = controller;
    }

    @Override
    public void selectWeapon(IWeapon weapon) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        CombatPhase that = (CombatPhase) o;
        return Objects.equals(controller, that.controller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controller);
    }

    @Override
    public void selectCharacter(ICharacter character) {

    }

    @Override
    public void attack(ICharacter attacker, ICharacter defender) {

    }

    @Override
    public void equipWeapon(IWeapon weapon, IPCharacter character) {

    }

    @Override
    public void selectAttackAction() {

    }

    @Override
    public void selectReturn() {

    }

    @Override
    public void selectWeaponAction() {

    }
}
