package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

public abstract class Weapon implements Object {
    private final String name;
    private int damage;
    private final int manaCost;
    private final String type;

    public Weapon(String name, int damage, int manaCost, String type) {
        if (damage < 0 || manaCost < 0) {
            throw new IllegalArgumentException("Damage and mana cost must be non-negative.");
        }
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.type = type;
    }

    @Override
    public void use(Entity target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }
        System.out.println(name + " strikes " + target.getName() + " causing " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public String getName() {
        return name;
    }


    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getType() {
        return type;
    }

    public void upgrade(int extraDamage) {
        if (extraDamage > 0) {
            this.damage += extraDamage;
            System.out.println(name + " has been upgraded! New damage: " + this.damage);
        }
    }

    @Override
    public String toString() {
        return name + " [Type: " + type + ", Damage: " + damage + ", Mana Cost: " + manaCost + "]";
    }
}
