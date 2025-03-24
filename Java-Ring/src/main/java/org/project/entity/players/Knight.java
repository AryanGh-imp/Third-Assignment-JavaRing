package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Knight extends Player {
    private int roundsSinceLastKick = 0;
    private final int kickDamage = 40;
    private final int kickCooldown = 3;

    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void strongKick(Entity target) {
        if (roundsSinceLastKick >= kickCooldown) {
            target.takeDamage(kickDamage);
            roundsSinceLastKick = 0;
            System.out.println(getName() + " performs a Strong Kick! Deals " + kickDamage + " damage.");
        } else {
            System.out.println(getName() + " can't use Strong Kick yet! (" + (kickCooldown - roundsSinceLastKick) + " rounds left)");
        }
    }

    public void endTurn() {
        roundsSinceLastKick++;
    }
}
