package com.github.cc3002.finalreality.controller.combatphases;


import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class WaitFillState extends CombatPhase{

    public WaitFillState() {
        super();
        //code to hide some buttons?
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WaitFillState)) return false;
        return super.equals(o);
    }

}
