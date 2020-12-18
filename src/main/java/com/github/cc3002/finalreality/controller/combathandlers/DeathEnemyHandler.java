package com.github.cc3002.finalreality.controller.combathandlers;

import com.github.cc3002.finalreality.controller.CombatController;

import java.beans.PropertyChangeEvent;

public class DeathEnemyHandler implements IEventHandler{
    private final CombatController controller;

    public DeathEnemyHandler(CombatController controller) {
        this.controller = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.countEnemyDeath();
    }
}
