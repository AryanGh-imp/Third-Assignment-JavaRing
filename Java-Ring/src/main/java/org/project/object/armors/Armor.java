package org.project.object.armors;

public abstract class Armor {
    private int defense;
    private final int maxDefense;
    private int durability;
    private final int maxDurability;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.maxDefense = defense;
        this.defense = defense;
        this.maxDurability = durability;
        this.durability = durability;
        this.isBroke = false;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void repair() {
        if (isBroke) {
            isBroke = false;
            defense = maxDefense;
            durability = maxDurability;
            System.out.println("Armor repaired! Defense and durability restored.");
        }
    }

    // Reduced armor durability after taking damage.
    public void reduceDurability(int damage) {
        durability -= damage;
        checkBreak();
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }

    // Get methods to get maximum defense and durability values
    public int getMaxDefense() {
        return maxDefense;
    }

    public int getMaxDurability() {
        return maxDurability;
    }
}
