package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Wizard extends Player {
    private final int spellManaCost = 20;
    private final int spellDamage = 30;
    private final int healAmount = 15;

    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void magicStrike(Entity target) {
        if (getCurrentMP() >= spellManaCost) {
            target.takeDamage(spellDamage);
            heal(healAmount);
            fillMana(-spellManaCost);
            System.out.println(getName() + " casts Magic Strike! Deals " + spellDamage + " damage and heals " + healAmount + " HP.");
        } else {
            System.out.println(getName() + " doesn't have enough mana!");
        }
    }
}
