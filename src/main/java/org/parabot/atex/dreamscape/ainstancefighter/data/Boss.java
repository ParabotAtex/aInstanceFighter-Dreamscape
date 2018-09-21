package org.parabot.atex.dreamscape.ainstancefighter.data;

public enum Boss {
    TANK("Tank", 43620),
    PHOENIX("Phoenix", 43621),
    MAGEGRAY("Magegray", 43622),
    ICY_SKELETON("Icy skeleton", 43623),
    SEA_TROLL_QUEEN("Sea troll queen", 43624),
    FLAME_TORVA("Flame torva", 43625),
    FLAME_PERNIX("Flame pernix", 43626),
    DRAGONBONE("Dragonbone", 43627),
    NEX("Nex", 43628),
    BORK("Bork", 43629),
    BARRELCHEST("Barrelchest", 43630),
    SHADOW_KING("Shadow king", 43631),
    VETION("Vet'ion", 43632),
    CHAOS_ELEMENTAL("Chaos elemental", 43633),
    OLAF("Olaf", 43634),
    NECROMANCER("Necromancer", 43635),
    GROUDON("Groudon", 43636);

    String name;
    int buttonId;
    Boss(String name, int buttonId) {
        this.name = name;
        this.buttonId = buttonId;
    }

    public String getName() {
        return name;
    }

    public int getButtonId() {
        return buttonId;
    }

    public String toString() {
        return name;
    }
}
