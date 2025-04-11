package org.project.entity.players;

import org.project.ANSI;
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
            System.out.println(ANSI.MAGENTA + ANSI.BOLD + getName()
                    + " casts MAGIC STRIKE!" + ANSI.RESET);
            System.out.println(ANSI.MAGENTA + "✨ Deals " + ANSI.BOLD + SPELL_DAMAGE
                    + ANSI.RESET + ANSI.MAGENTA + " damage and heals "
                    + ANSI.GREEN + ANSI.BOLD + HEAL_AMOUNT + ANSI.RESET + ANSI.MAGENTA + " HP! ✨" + ANSI.RESET);
        } else {
            System.out.println(ANSI.RED + getName()
                    + " doesn't have enough mana!" + ANSI.RESET);
        }
    }
}
