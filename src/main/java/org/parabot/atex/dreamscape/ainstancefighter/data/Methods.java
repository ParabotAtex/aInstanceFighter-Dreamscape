package org.parabot.atex.dreamscape.ainstancefighter.data;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.core.ui.Logger;
import org.parabot.environment.scripts.Script;
import org.rev317.min.api.methods.Interfaces;

import java.text.DecimalFormat;

public class Methods {
    public static void stopScript(String reason) {
        Logger.addMessage(reason);
        Core.getInstance().setState(Script.STATE_STOPPED);
    }

    public static int getHealth() {
        try {
            return Integer.parseInt(Interfaces.getInterface(Constants.HEALTH_INTERFACE_ID).getMessage());
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    public static int getHitpointsLevel() {
        try {
            return Integer.parseInt(Interfaces.getInterface(Constants.HITPOINTS_LEVEL_INTERFACE_ID).getMessage().split("/")[1]);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getPrayer() {
        try {
            return Integer.parseInt(Interfaces.getInterface(Constants.PRAYER_INTERFACE_ID).getMessage());
        } catch(NullPointerException ex) {
            return 0;
        }
    }

    public static int getPrayerLevel() {
        try {
            return Integer.parseInt(Interfaces.getInterface(Constants.PRAYER_LEVEL_INTERFACE_ID).getMessage().split("/")[1]);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getKillsLeft() {
        try {
            String s = Interfaces.getInterface(Constants.KILLS_LEFT_INTERFACE_ID).getMessage();
            s = s.split("/")[0];
            s = s.substring(s.indexOf("@red@") + 5, s.indexOf("@whi@"));
            return Integer.parseInt(s);
        } catch(NullPointerException ex) {
            return 0;
        }
    }

    public static long getPerHour(int currentAmount, int startAmount, long start) {
        return (int)(((double)(currentAmount - startAmount) * 3600000D) / (double)(System.currentTimeMillis() - start));
    }

    public static String getRunTime(long start) {
        DecimalFormat df = new DecimalFormat("00");
        long currentTime = System.currentTimeMillis() - start;
        long hours = currentTime / (3600000);
        currentTime -= hours * (3600000);
        long minutes = currentTime / (60000);
        currentTime -= minutes * (60000);
        long seconds = currentTime / (1000);
        return df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds);
    }
}
