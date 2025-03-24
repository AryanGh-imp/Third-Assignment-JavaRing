package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

public class Sword extends Weapon {

    private int abilityCharge; // unique ability charge amount
    private final int abilityThreshold; // minimum charge required to use

    public Sword(String name, String description, int damage, int manaCost) {
        super(name, description, damage, manaCost, "Sword");
        this.abilityCharge = 0;
        this.abilityThreshold = 5; // default
    }

    public void use(Entity target) {
        super.use(target);
        abilityCharge++; // each time the sword is used, the unique ability charge increases
    }

    // uniqueAbility : attack all enemies
    public void uniqueAbility(ArrayList<Entity> targets) {
        if (abilityCharge >= abilityThreshold) {
            System.out.println(getName() + " unleashes a powerful slash!");
            for (Entity target : targets) {
                target.takeDamage(getDamage() * 2); // double damage on unique ability attack
            }
            abilityCharge = 0; // after use, it becomes 0
        } else {
            System.out.println(getName() + " doesn't have enough charge to use the ability!");
        }
    }

    public int getAbilityCharge() {
        return abilityCharge;
    }

    public void setAbilityCharge(int charge) {
        this.abilityCharge = charge;
    }

    public int getAbilityThreshold() {
        return abilityThreshold;
    }

    @Override
    public String toString() {
        return super.toString() + " [Ability Charge: " + abilityCharge + "/" + abilityThreshold + "]";
    }
}
