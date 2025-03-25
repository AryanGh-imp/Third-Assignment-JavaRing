package org.project.object.armors;

import org.project.entity.Entity;

public abstract class Armor {
    private final String name;
    private int defense;
    private final int maxDefense;
    private int durability;
    private final int maxDurability;
    private boolean isBroke;

    public Armor(String name, int defense, int durability) {
        this.name = name;
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

    public String getName(){
        return name;
    }

    public abstract void use(Entity target);
}
