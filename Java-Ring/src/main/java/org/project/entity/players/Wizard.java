package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Wizard extends Player {
    public static final int SPELL_MANA_COST = 20;
    public static final int SPELL_DAMAGE = 30;
    public static final int HEAL_AMOUNT = 15;

    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void magicStrike(Entity target) {
        if (getCurrentMP() >= SPELL_MANA_COST) {
            target.takeDamage(SPELL_DAMAGE);
            heal(HEAL_AMOUNT);
            fillMana(-SPELL_MANA_COST);
            System.out.println(getName() + " casts Magic Strike! Deals " + SPELL_DAMAGE +
                    " damage and heals " + HEAL_AMOUNT + " HP.");
        } else {
            System.out.println(getName() + " doesn't have enough mana!");
        }
    }
}
