package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Assassin extends Player {
    private boolean isInvisible = false;
    private final double STEALTH_MULTIPLIER = 1.5;
    private final int STEALTH_COST = 15;

    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void enterStealth() {
        if (getCurrentMP() >= STEALTH_COST) {
            isInvisible = true;
            fillMana(-STEALTH_COST);
            System.out.println(getName() + " enters Stealth Mode and becomes invisible!");
        } else {
            System.out.println(getName() + " doesn't have enough mana for stealth!");
        }
    }

    @Override
    public void attack(Entity target) {
        if (isInvisible) {
            System.out.println(getName() + " launches a powerful attack from Stealth!");
            target.takeDamage((int) (getWeapon().getDamage() * STEALTH_MULTIPLIER));
            isInvisible = false;
        } else {
            super.attack(target);
        }
    }

    // New getter method
    public boolean isInvisible() {
        return isInvisible;
    }
}