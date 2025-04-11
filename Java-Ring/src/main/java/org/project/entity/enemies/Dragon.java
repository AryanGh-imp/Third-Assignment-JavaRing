package org.project.entity.enemies;

import org.project.ANSI;
import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

import java.util.List;

public class Dragon extends Enemy {
    public Dragon(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {
        System.out.println(ANSI.RED + ANSI.BOLD + name + ANSI.RESET + " " + ANSI.RED + "breathes fire at "
                + ANSI.YELLOW + target.getName() + ANSI.RED + ", ignoring defenses!" + ANSI.RESET);
        target.takeDamage(weapon.getDamage());
    }

    public void attackAll(List<Entity> players) {
        int fireDamage = weapon.getDamage() + 10;
        System.out.println(ANSI.RED + ANSI.BOLD + "\n" + name + " UNLEASHES A FIERY INFERNO!" + ANSI.RESET);
        System.out.println(ANSI.RED + "🔥 " + name + "'s fiery blast hits ALL players for "
                + ANSI.BOLD + fireDamage + ANSI.RESET + ANSI.RED + " damage each! 🔥" + ANSI.RESET);

        for (Entity player : players) {
            player.takeDamage(fireDamage);
        }
    }
}