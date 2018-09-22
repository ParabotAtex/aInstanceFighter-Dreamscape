package org.parabot.atex.dreamscape.ainstancefighter.data;

public enum Potion {
    SUPER_RESTORE("Super restore", new int[]{3025, 3027, 3029, 3031}),
    PRAYER_POTION("Prayer potion", new int[]{2435,140,142,144}),
    RESTORE_FLASK("Super restore flask", new int[]{20644, 20645, 20646, 20647, 20648, 20649}),
    PRAYER_FLASK("Prayer flask", new int[]{20602, 20603, 20604, 20605, 20606, 20607});

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
