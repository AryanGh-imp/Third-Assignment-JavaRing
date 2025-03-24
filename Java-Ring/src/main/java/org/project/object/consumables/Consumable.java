package org.project.object.consumables;

import org.project.object.Object;
import org.project.entity.Entity;

public abstract class Consumable implements Object {

    private final String name;
    private final String description;
    private int quantity;

    public Consumable(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = Math.max(quantity, 0);
    }

    @Override
    public void use(Entity target) {
        if (quantity > 0) {
            applyEffect(target);
            quantity--;
            System.out.println(target.getName() + " used " + name + ". " + quantity + " left.");
        } else {
            System.out.println("No " + name + " left!");
        }
    }

    // a method that is implemented in subclasses
    protected abstract void applyEffect(Entity target);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return name + " (" + description + ") - Remaining: " + quantity;
    }
}
