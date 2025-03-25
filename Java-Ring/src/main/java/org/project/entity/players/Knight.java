package org.project.entity.players;

import org.project.ANSI;
import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Knight extends Player {
    private int roundsSinceLastKick = 0;
    private final int KICK_DAMAGE = 40;
    private final int KICK_COOLDOWN = 3;
    private final int KICK_COST = 10;

    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void strongKick(Entity target) {
        if (roundsSinceLastKick >= KICK_COOLDOWN && getCurrentMP() >= KICK_COST) {
            target.takeDamage(KICK_DAMAGE);
            roundsSinceLastKick = 0;
            fillMana(-KICK_COST);
            System.out.println(ANSI.RED + ANSI.BOLD + getName()
                    + " performs a MIGHTY STRONG KICK!" + ANSI.RESET);
            System.out.println(ANSI.RED + "💥 Deals " + ANSI.BOLD + KICK_DAMAGE
                    + ANSI.RESET + ANSI.RED + " crushing damage! 💥" + ANSI.RESET);
        } else if (getCurrentMP() < KICK_COST) {
            System.out.println(ANSI.RED + getName()
                    + " doesn't have enough mana for a Strong Kick!" + ANSI.RESET);
        } else {
            System.out.println(ANSI.YELLOW + getName() + " can't use Strong Kick yet! ("
                    + (KICK_COOLDOWN - roundsSinceLastKick) + " rounds left)" + ANSI.RESET);
        }
    }

    public void endTurn() {
        roundsSinceLastKick++;
    }

    // New getter methods
    public int getRoundsSinceLastKick() {
        return roundsSinceLastKick;
    }

    public int getKickCooldown() {
        return KICK_COOLDOWN;
    }
}