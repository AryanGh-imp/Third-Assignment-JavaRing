package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Assassin extends Player {
    private boolean isInvisible = false;
    private final double attackMultiplier = 1.5;

    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void enterStealth() {
        isInvisible = true;
        System.out.println(getName() + " enters Stealth Mode and becomes invisible!");
    }

    @Override
    public void takeDamage(int damage) {
        if (isInvisible) {
            System.out.println(getName() + " is in Stealth Mode and avoids the attack!");
        } else {
            super.takeDamage(damage);
        }
    }

    @Override
    public void attack(Entity target) {
        if (isInvisible) {
            System.out.println(getName() + " launches a powerful attack from Stealth!");
            target.takeDamage((int) (getWeapon().getDamage() * attackMultiplier));
            isInvisible = false;
        } else {
            super.attack(target);
        }
    }
}
