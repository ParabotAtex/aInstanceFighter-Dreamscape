package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import com.sun.deploy.util.ArrayUtil;
import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.atex.dreamscape.ainstancefighter.data.Methods;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Items;

import static org.parabot.atex.dreamscape.ainstancefighter.data.Methods.getPrayerLevel;

public class UsePotions implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.getCount(Core.getSettings().getPotion().getDoses()) > 0
                && (Methods.getPrayer() / (double)getPrayerLevel()) * 100 < Core.getSettings().getPrayerThreshold()
                && Core.getSettings().getPotionCount() > 0;
    }

    @Override
    public void execute() {
        int[] doses = Core.getSettings().getPotion().getDoses();
        for (int i = doses.length - 1; i >= 0; i--) {
            if(Inventory.getCount(doses[i]) > 0) {
                Inventory.getItem(doses[i]).interact(Items.Option.DRINK);
                break;
            }
        }
        Time.sleep(1000);
    }
}
