package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.atex.dreamscape.ainstancefighter.data.Methods;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Items;

public class UsePotions implements Strategy {
    @Override
    public boolean activate() {
        return Methods.getPrayer() < Core.getSettings().getPrayerThreshold()
                && Core.getSettings().getPotionCount() > 0;
    }

    @Override
    public void execute() {
        if(Inventory.getCount(Core.getSettings().getPotion().getDoses()) == 0) return;
        for(int id : Core.getSettings().getPotion().getDoses()) {
            if(Inventory.getCount(id) > 0) {
                Inventory.getItem(id).interact(Items.Option.DRINK);
                break;
            }
        }
        Time.sleep(1000);
    }
}
