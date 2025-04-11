package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    private final int healAmount;

    public Flask(String name, String description, int healAmount, int quantity) {
        super(name, description, quantity);
        this.healAmount = healAmount;
    }

    @Override
    public void applyEffect(Entity target) {
        int healValue = Math.max(target.getMaxHP() * healAmount / 100, 1); // min: 1
        target.heal(healValue);
        System.out.println(target.getName() + " used " + getName() + " and restored " + healValue + " HP. " +
                "Remaining: " + getQuantity());
    }

    @Override
    public String toString() {
        return getName() + " (" + getDescription() + ") - Restores " + healAmount + "% HP - Remaining: " + getQuantity();
    }
}