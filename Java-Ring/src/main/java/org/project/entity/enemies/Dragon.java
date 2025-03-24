package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

import java.util.List;

public class Dragon extends Enemy {
    public Dragon(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {
        System.out.println(name + " breathes fire at " + target.getName() + ", ignoring defenses!");
        target.takeDamage(weapon.getDamage());
    }

    public void attackAll(List<Entity> players) {
        System.out.println(name + " unleashes a fiery blast, hitting all players!");
        for (Entity player : players) {
            player.takeDamage(weapon.getDamage());
        }
    }
}
