package org.parabot.atex.dreamscape.ainstancefighter.data;

public enum Potion {
    SUPER_RESTORE("Super restore", new int[]{3025, 3027, 3029, 3031});

    int[] doses;
    String name;

    Potion(String name, int[] doses) {
        this.doses = doses;
        this.name = name;
    }

    public int[] getDoses() {
        return doses;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
