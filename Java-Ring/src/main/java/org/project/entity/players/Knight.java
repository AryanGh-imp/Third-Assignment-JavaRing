package org.project.entity.players;

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
            System.out.println(getName() + " performs a Strong Kick! Deals " + KICK_DAMAGE + " damage.");
        } else if (getCurrentMP() < KICK_COST) {
            System.out.println(getName() + " doesn't have enough mana for a Strong Kick!");
        } else {
            System.out.println(getName() + " can't use Strong Kick yet! (" +
                    (KICK_COOLDOWN - roundsSinceLastKick) + " rounds left)");
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