package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    private int hp;
    private final int maxHP;
    private int mp;
    private final int maxMP;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp;
        this.mp = mp;
        this.maxMP = mp;
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        System.out.println(name + " attacks " + target.getName() + " with " + weapon.getName() + "!");
        target.takeDamage(weapon.getDamage());
    }

    @Override
    public void defend() {
        int defense = armor.getDefense();
        System.out.println(name + " raises " + armor.getName() + " to defend! Defense: " + defense);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(damage - armor.getDefense(), 0);
        hp -= reducedDamage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(name + " takes " + reducedDamage + " damage! HP left: " + hp);
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

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(name + " equips " + newWeapon.getName() + "!");
    }

    public void setArmor(Armor newArmor) {
        this.armor = newArmor;
        System.out.println(name + " equips " + newArmor.getName() + "!");
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

}
