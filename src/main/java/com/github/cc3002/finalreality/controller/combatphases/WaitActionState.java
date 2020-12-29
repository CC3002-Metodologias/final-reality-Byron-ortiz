package com.github.cc3002.finalreality.controller.combatphases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class WaitActionState extends CombatPhase {

    public WaitActionState() {
        super();
        // code to activate buttons
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WaitActionState)) return false;
        return super.equals(o);
    }


        @Override
    public void selectWeapon(IWeapon weapon) {

    }

    @Override
    public void selectCharacter(ICharacter character) {

    }


    @Override
    public void equipWeapon(IWeapon weapon, IPCharacter character) {

    }

    @Override
    public void selectAttackAction() {
        // code to hide some buttons
        controller.setPhase(new SelectingAttackPhase());
    }

    @Override
    public void selectReturn() {
    }

    @Override
    public void selectWeaponAction() {
        controller.setPhase(new SelectingWeaponPhase());
    }
}
