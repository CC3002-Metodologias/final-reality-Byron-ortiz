package com.github.cc3002.finalreality.controller.combatphases;


/**
 * this class was created to interact with the gui. NOT IMPLEMENTED YET
 */
public class SelectingWeaponPhase extends CombatPhase {

    public SelectingWeaponPhase() {
        super();
        // code to show and hide some buttons
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SelectingWeaponPhase)) return false;
        return super.equals(o);
    }

    @Override
    public void selectReturn() {
        controller.setPhase(new WaitActionState());
    }
}
