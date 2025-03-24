package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    private final int healAmount;
    private int quantity;

    public Flask(String name, String description, int healAmount, int quantity) {
        super(name, description, quantity);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Entity target) {
        applyEffect(target);
    }

    @Override
    public void applyEffect(Entity target) {
        if (quantity > 0) {
            int healValue = Math.max(target.getMaxHP() * healAmount / 100, 1); // min : 1
            target.heal(healValue);
            quantity--;
            System.out.println(target.getName() + " used " + getName() + " and restored " + healValue + " HP. " +
                    "Remaining: " + quantity);
        } else {
            System.out.println("No " + getName() + " left!");
        }
    }

    @Override
    public boolean isUsable() {
        return quantity > 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return getName() + " (" + getDescription() + ") - Restores " + healAmount + "% HP - Remaining: " + quantity;
    }
}
