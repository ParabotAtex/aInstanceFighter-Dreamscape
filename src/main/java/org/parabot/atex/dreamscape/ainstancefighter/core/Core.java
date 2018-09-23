package org.parabot.atex.dreamscape.ainstancefighter.core;

import org.parabot.atex.dreamscape.ainstancefighter.ui.GUI;
import org.parabot.atex.dreamscape.ainstancefighter.ui.Overlay;
import org.parabot.atex.dreamscape.ainstancefighter.data.Settings;
import org.parabot.atex.dreamscape.ainstancefighter.strategies.*;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import java.awt.*;
import java.util.ArrayList;

@ScriptManifest(author = "Atex",
        category = Category.COMBAT,
        description = "Kills bosses in iron man instances",
        name = "aInstanceFighter", servers = { "Dreamscape" },
        version = 0.4)
public class Core extends Script implements Paintable {
    private ArrayList<Strategy> strategies = new ArrayList<>();
    private static Overlay overlay = new Overlay();
    private static Settings settings;
    private static Script core;

    @Override
    public boolean onExecute() {
        strategies.add(new Banking());
        strategies.add(new Heal());
        strategies.add(new UsePotions());
        strategies.add(new Pray());

        strategies.add(new AntiAfk());
        strategies.add(new EnterInstance());
        strategies.add(new Looting());
        strategies.add(new InInstance());
        provide(strategies);

        core = this;

        GUI gui = new GUI();
        while(gui.isVisible()) {
            Time.sleep(100);
        }

        if(gui.getSettings() == null) {
            overlay.dispose();
            return false;
        } else {
            settings = gui.getSettings();
        }

        return true;
    }

    public static Settings getSettings() {
        return settings;
    }

    public static Overlay getOverlay() {
        return overlay;
    }

    public static Script getInstance() {
        return core;
    }

    @Override
    public void paint(Graphics graphics) {
        overlay.draw(graphics);
    }
}
