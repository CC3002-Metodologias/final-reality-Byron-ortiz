package com.github.cc3002.finalreality.controller.combatphases;

public class CombatEndedPhase extends CombatPhase {

    public CombatEndedPhase() {
        super();
        // show play again button or exit
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CombatEndedPhase)) return false;
        return super.equals(o);
    }

}
