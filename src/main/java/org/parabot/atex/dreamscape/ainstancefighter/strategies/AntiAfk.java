package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.data.Constants;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.wrappers.Tile;

import static org.rev317.min.api.methods.Players.getMyPlayer;
import static org.rev317.min.api.methods.Walking.walkTo;

public class AntiAfk implements Strategy {
    private boolean direction = false;
    private long lastMoved = System.currentTimeMillis();

    @Override
    public boolean activate() {
        return Constants.ARENA_CENTER_TILE.distanceTo() < 20 && System.currentTimeMillis() > lastMoved + 30000;
    }

    @Override
    public void execute() {
        walkTo(new Tile(getMyPlayer().getLocation().getX() + (direction ? -1 : 1), getMyPlayer().getLocation().getY()));
        direction = !direction;
        lastMoved = System.currentTimeMillis();
    }
}
