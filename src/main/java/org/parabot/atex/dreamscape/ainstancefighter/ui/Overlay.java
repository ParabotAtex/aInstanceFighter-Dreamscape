package org.parabot.atex.dreamscape.ainstancefighter.ui;

import org.parabot.atex.dreamscape.ainstancefighter.data.Constants;
import org.parabot.atex.dreamscape.ainstancefighter.data.Methods;

import java.awt.*;

public class Overlay {
    private Graphics2D graphics;
    private int kills = 0;

    //START: Code generated using Enfilade's Easel
    private final Color color1 = new Color(100, 100, 100, 150);
    private final Color color2 = new Color(50, 50, 50, 200);
    private final Color color3 = new Color(255, 255, 255);

    private final BasicStroke stroke1 = new BasicStroke(2);

    private final Font font1 = new Font("Arial", 0, 13);

    public void draw(Graphics g1) {
        graphics = (Graphics2D)g1;
        graphics.setColor(color1);
        graphics.fillRect(239, 10, 266, 53);
        graphics.setColor(color2);
        graphics.setStroke(stroke1);
        graphics.drawRect(239, 10, 266, 53);
        graphics.setFont(font1);
        graphics.setColor(color3);
        graphics.drawString("Boss kills:", 370, 29);
        graphics.drawString(kills+"", 438, 29);
        graphics.drawString("Kills per hour:", 246, 50);
        graphics.drawString(Methods.getPerHour(kills,0,Constants.START_TIME)+"", 340, 50);
        graphics.drawString("Run time:", 246, 29);
        graphics.drawString(Methods.getRunTime(Constants.START_TIME), 304, 29);
    }
    //END: Code generated using Enfilade's Easel

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void dispose() {
        graphics.dispose();
    }
}
