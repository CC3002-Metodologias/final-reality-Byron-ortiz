package com.github.cc3002.finalreality.controller.combatphases;

/**
 * this class was created to interact with the gui. NOT IMPLEMENTED YET
 */
public class SelectingAttackPhase extends CombatPhase {

    public SelectingAttackPhase() {
        super();
        //code to hide and show other buttons
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SelectingAttackPhase)) return false;
        return super.equals(o);
    }

    @Override
    public void selectReturn() {
        controller.setPhase(new WaitActionState());
    }

}
