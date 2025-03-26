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
        if (isBroke()) {
            defense = 0;
        }
    }

    // Reduced armor durability after taking damage.
    public void reduceDurability(int amount) {
        durability -= amount;
        if (durability < 0) {
            durability = 0;
        }
        checkBreak();
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public abstract int getMaxDurability();

    public boolean isBroke() {
        return durability <= 0;
    }

    public String getName(){
        return name;
    }

    public abstract void use(Entity target);
}
