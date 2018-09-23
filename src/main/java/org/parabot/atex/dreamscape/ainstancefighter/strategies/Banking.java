package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.atex.dreamscape.ainstancefighter.data.Constants;
import org.parabot.atex.dreamscape.ainstancefighter.data.Methods;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class Banking implements Strategy {
    @Override
    public boolean activate() {
        return SceneObjects.getClosest(Constants.BANK_CHEST_ID) != null
                && (Inventory.getCount(Core.getSettings().getFoodId()) == 0 && Core.getSettings().getFoodCount() > 0
                || Inventory.getCount(Core.getSettings().getPotion().getDoses()) == 0 && Core.getSettings().getPotionCount() > 0
                || Inventory.isFull());
    }

    @Override
    public void execute() {
        if(!Bank.isOpen()) {
            SceneObject chest = SceneObjects.getClosest(Constants.BANK_CHEST_ID);
            if(chest == null) return;
            Bank.open(chest);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Bank.isOpen();
                }
            }, 2000);
        }
        if(Bank.isOpen()) {
            if(!Inventory.isEmpty()) {
                Menu.clickButton(Constants.DEPOSIT_ALL_ID);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Inventory.isEmpty();
                    }
                }, 2000);
            }

            if(Bank.getCount(Core.getSettings().getFoodId()) < Core.getSettings().getFoodCount()) Methods.stopScript("Out of food, stopping script");
            if(Bank.getCount(Core.getSettings().getPotion().getDoses()[0]) < Core.getSettings().getPotionCount()) Methods.stopScript("Out of potions, stopping script");

            if(Inventory.isEmpty()) {
                if(Core.getSettings().getFoodCount() > 0) {
                    Bank.withdraw(Core.getSettings().getFoodId(), Core.getSettings().getFoodCount(), 1000);
                    Time.sleep(1000);
                }
                if(Core.getSettings().getPotionCount() > 0) {
                    Bank.withdraw(Core.getSettings().getPotion().getDoses()[0], Core.getSettings().getPotionCount(), 1000);
                    Time.sleep(1000);
                }
            }
        }
    }
}
