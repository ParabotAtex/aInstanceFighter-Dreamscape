package org.parabot.atex.dreamscape.ainstancefighter.data;

public enum Boss {
    TANK("Tank", 43620, 5087),
    PHOENIX("Phoenix", 43621, 8576),
    MAGEGRAY("Magegray", 43622, 707),
    ICY_SKELETON("Icy skeleton", 43623, 9177),
    SEA_TROLL_QUEEN("Sea troll queen", 43624, 3847),
    FLAME_TORVA("Flame torva", 43625, 9999),
    FLAME_PERNIX("Flame pernix", 43626, 10001),
    DRAGONBONE("Dragonbone", 43627, 2586),
    NEX("Nex", 43628, 2636),
    BORK("Bork", 43629, 7133),
    BARRELCHEST("Barrelchest", 43630, 5666),
    SHADOW_KING("Shadow king", 43631, 10070),
    VETION("Vet'ion", 43632, 9003),
    CHAOS_ELEMENTAL("Chaos elemental", 43633, 3200),
    OLAF("Olaf", 43634, 25060),
    NECROMANCER("Necromancer", 43635, 25010),
    GROUDON("Groudon", 43636, 30009);

    String name;
    int buttonId;
    int id;

    Boss(String name, int buttonId, int id) {
        this.name = name;
        this.buttonId = buttonId;
        this.id = id;
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

    public int getId() {
        return id;
    }
}
