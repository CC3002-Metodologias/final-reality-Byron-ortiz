package com.github.cc3002.finalreality.controller.combathandlers;

import com.github.cc3002.finalreality.controller.CombatController;

import java.beans.PropertyChangeEvent;

public class ReadyToPlayHandler implements IEventHandler {
    private final CombatController controller;

    public ReadyToPlayHandler(CombatController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue().equals(controller.getTurnOwner()) || controller.getTurnOwner()==null) {
            controller.beginTurn();
        }
    }
}
