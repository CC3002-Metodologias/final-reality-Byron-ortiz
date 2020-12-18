package com.github.cc3002.finalreality.controller.combathandlers;

import com.github.cc3002.finalreality.controller.CombatController;

import java.beans.PropertyChangeEvent;

public class DeathPlayerHandler implements IEventHandler{
    private final CombatController controller;

    public DeathPlayerHandler(CombatController controller) {
        this.controller = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.countPlayerDeath();
    }
}
