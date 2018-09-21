package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.GroundItems;
import org.rev317.min.api.wrappers.GroundItem;

public class Looting implements Strategy {
    @Override
    public boolean activate() {
        return GroundItems.getGroundItems().length > 0;
    }

    @Override
    public void execute() {
        for(GroundItem item : GroundItems.getGroundItems()) {
            item.take();
            Time.sleep(1000);
        }
    }
}
