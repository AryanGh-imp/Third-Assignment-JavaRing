package org.project.entity.enemies;

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
        hp = maxHP / 2; // return with %50 HP
        System.out.println(name + " rises from the dead with " + hp + " HP!");
    }
}
