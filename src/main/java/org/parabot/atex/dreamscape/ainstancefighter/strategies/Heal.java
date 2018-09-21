package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Items;

import static org.parabot.atex.dreamscape.ainstancefighter.data.Methods.getHealth;

public class Heal implements Strategy {
    @Override
    public boolean activate() {
        return getHealth() < Core.getSettings().getHealthThreshold()
                && Core.getSettings().getFoodCount() > 0;
    }

    @Override
    public void execute() {
        if(Inventory.getCount(Core.getSettings().getFoodId()) == 0) return;

        Inventory.getItem(Core.getSettings().getFoodId()).interact(Items.Option.CONSUME);
        Time.sleep(500);
    }
}
