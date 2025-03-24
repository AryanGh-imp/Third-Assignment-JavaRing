package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public abstract class Enemy implements Entity {
    protected Weapon weapon;
    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;

    public Enemy(String name, int hp, int mp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp;
        this.mp = mp;
        this.maxMP = mp;
        this.weapon = weapon;
    }

    @Override
    public void attack(Entity target) {
        System.out.println(name + " attacks " + target.getName() + " with " + weapon.getName() + "!");
        target.takeDamage(weapon.getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage, 0);
        hp -= actualDamage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(name + " takes " + actualDamage + " damage! HP left: " + hp);
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println(name + " heals for " + health + " HP. Current HP: " + hp);
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
        System.out.println(name + " restores " + mana + " MP. Current MP: " + mp);
    }

    @Override
    public void defend() {
        System.out.println(name + " tries to defend, but it's not very effective!");
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentHP() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getCurrentMP() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(name + " equips " + newWeapon.getName() + "!");
    }
}
