package com.github.cc3002.finalreality.controller.combathandlers;

import com.github.cc3002.finalreality.controller.CombatController;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

public class ChangeTurnHandler implements IEventHandler {

    private final CombatController controller;

    public ChangeTurnHandler(CombatController controller) {

        this.controller = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String beginOrEnd = evt.getPropertyName();
        if (beginOrEnd == "begin") {
            controller.turnBegan((ICharacter) evt.getNewValue());
        }
        else {
            controller.turnEnded((ICharacter) evt.getOldValue());
        }
    }
}
