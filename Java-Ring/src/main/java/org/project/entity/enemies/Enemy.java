package org.project.entity.enemies;

import org.project.ANSI;
import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public abstract class Enemy implements Entity {
    protected Weapon weapon;
    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;
    private final int initialHP;
    private boolean isDefending = false;

    public Enemy(String name, int hp, int mp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp;
        this.mp = mp;
        this.maxMP = mp;
        this.weapon = weapon;
        this.initialHP = hp;
    }

    @Override
    public void attack(Entity target) {
        System.out.println(ANSI.YELLOW + name + ANSI.RESET + " attacks "
                + ANSI.CYAN + target.getName() + ANSI.RESET + " with "
                + ANSI.BLUE + weapon.getName() + ANSI.RESET + "!");
        target.takeDamage(weapon.getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = isDefending ? damage / 2 : damage;
        actualDamage = Math.max(actualDamage, 0);
        hp -= actualDamage;
        isDefending = false;

        if (hp < 0) {
            hp = 0;
        }

        System.out.println(ANSI.YELLOW + name + ANSI.RESET + " takes "
                + ANSI.RED + ANSI.BOLD + actualDamage + ANSI.RESET + " damage! "
                + ANSI.GREEN + "HP left: " + hp + ANSI.RESET);
    }

    public void restoreHealth() {
        this.hp = initialHP;
        System.out.println(ANSI.GREEN + ANSI.BOLD + name + " has been fully restored to "
                + initialHP + " HP!" + ANSI.RESET);
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println(ANSI.GREEN + name + " heals for " + ANSI.GREEN + ANSI.BOLD
                + health + ANSI.RESET + ANSI.GREEN + " HP. " + ANSI.YELLOW + "Current HP: "
                + hp + "/" + maxHP + ANSI.RESET);
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
        isDefending = true;
        System.out.println(name + " braces for an attack, reducing incoming damage!");
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

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }
}
