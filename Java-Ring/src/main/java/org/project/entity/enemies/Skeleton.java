package org.project.entity.enemies;

import org.project.ANSI;
import org.project.object.weapons.Weapon;

public class Skeleton extends Enemy {
    private boolean resurrected = false;

    public Skeleton(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (hp <= 0 && !resurrected) {
            resurrect();
        }
    }

    private void resurrect() {
        resurrected = true;
        hp = maxHP / 2;
        System.out.println(ANSI.MAGENTA + ANSI.BOLD + "\n" + name
                + " RISES FROM THE DEAD!" + ANSI.RESET);
        System.out.println(ANSI.MAGENTA + "☠️ " + name + " returns with "
                + ANSI.YELLOW+ ANSI.BOLD + hp + ANSI.RESET + ANSI.MAGENTA + " HP! ☠️" + ANSI.RESET);
    }
}
