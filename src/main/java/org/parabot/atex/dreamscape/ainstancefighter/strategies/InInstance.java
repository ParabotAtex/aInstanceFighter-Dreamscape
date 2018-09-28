package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.atex.dreamscape.ainstancefighter.data.Constants;
import org.parabot.environment.api.utils.Filter;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Npc;

import static org.parabot.atex.dreamscape.ainstancefighter.data.Methods.getKillsLeft;
import static org.rev317.min.api.methods.Players.getMyPlayer;
import static org.rev317.min.api.methods.Walking.walkTo;


public class InInstance implements Strategy {
    private int totalKills = 0;
    private int lastKillsLeft = 0;
    @Override
    public boolean activate() {
        return Constants.ARENA_CENTER_TILE.distanceTo() < 20;
    }

    @Override
    public void execute() {
        if(Constants.ARENA_CENTER_TILE.distanceTo() > 4) {
            walkTo(Constants.ARENA_CENTER_TILE);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Constants.ARENA_CENTER_TILE.distanceTo() < 5;
                }
            }, 1000);
        }
        if(!getMyPlayer().isInCombat() && Npcs.getNpcs().length > 0 && Constants.ARENA_CENTER_TILE.distanceTo() < 5) {
            if(Npcs.getClosest(Core.getSettings().getSelectedBoss().getId()) != null) {
                Npcs.getClosest(Core.getSettings().getSelectedBoss().getId()).interact(Npcs.Option.ATTACK);
                Time.sleep(new SleepCondition() {
                        @Override
                        public boolean isValid() {
                            return getMyPlayer().isInCombat();
                        }
                    },500);
            }
        }
        updateOverlay();
        Time.sleep(100);
    }

    private void updateOverlay() {
        if(lastKillsLeft == 0) {
            lastKillsLeft = getKillsLeft();
        } else if(getKillsLeft() < lastKillsLeft) {
            totalKills += lastKillsLeft - getKillsLeft();
            Core.getOverlay().setKills(totalKills);
            lastKillsLeft = getKillsLeft();
        } else if(getKillsLeft() > lastKillsLeft) {
            lastKillsLeft = getKillsLeft();
            totalKills++;
            Core.getOverlay().setKills(totalKills);
        }
    }


}
