package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Goblin extends Enemy {
    public Goblin(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {
        System.out.println(name + " swings its weapon at " + target.getName() + "!");
        super.attack(target);
    }
}
