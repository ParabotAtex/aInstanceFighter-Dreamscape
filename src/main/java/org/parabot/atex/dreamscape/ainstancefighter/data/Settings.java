package org.parabot.atex.dreamscape.ainstancefighter.data;


import org.rev317.min.api.methods.Prayer;

import java.util.ArrayList;

public class Settings {
    private int foodId;
    private Potion potion;
    private int prayerThreshold;
    private int healthThreshold;
    private int foodCount;
    private int potionCount;
    private Boss selectedBoss;
    private ArrayList<Prayer.Curse> curses;

    public Settings(int foodId, Potion potion, int prayerThreshold, int healthThreshold, int foodCount, int potionCount, Boss selectedBoss, ArrayList<Prayer.Curse> curses) {
        this.foodId = foodId;
        this.potion = potion;
        this.prayerThreshold = prayerThreshold;
        this.healthThreshold = healthThreshold;
        this.foodCount = foodCount;
        this.potionCount = potionCount;
        this.selectedBoss = selectedBoss;
        this.curses = curses;
    }

    public int getFoodId() {
        return foodId;
    }

    public int getPrayerThreshold() {
        return prayerThreshold;
    }

    public int getHealthThreshold() {
        return healthThreshold;
    }

    public Potion getPotion() {
        return potion;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public int getPotionCount() {
        return potionCount;
    }

    public Boss getSelectedBoss() {
        return selectedBoss;
    }

    public ArrayList<Prayer.Curse> getCurses() {
        return curses;
    }
}
