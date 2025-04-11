package org.project.entity.players;

import org.project.ANSI;
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
            System.out.println(ANSI.MAGENTA + ANSI.BOLD + getName()
                    + " vanishes into the shadows!" + ANSI.RESET);
            System.out.println(ANSI.MAGENTA + "✨ " + getName()
                    + " is now INVISIBLE! ✨" + ANSI.RESET);
        } else {
            System.out.println(ANSI.RED + getName()
                    + " doesn't have enough mana for stealth!" + ANSI.RESET);
        }
    }

    @Override
    public void attack(Entity target) {
        if (isInvisible) {
            System.out.println(ANSI.MAGENTA + ANSI.BOLD + getName()
                    + " strikes from the shadows!" + ANSI.RESET);
            System.out.println(ANSI.MAGENTA + "🗡️ CRITICAL STEALTH ATTACK! 🗡️" + ANSI.RESET);
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