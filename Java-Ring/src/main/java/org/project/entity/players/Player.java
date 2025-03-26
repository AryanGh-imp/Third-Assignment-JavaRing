package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;
import org.project.ANSI;

public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    private int hp;
    private final int maxHP;
    private int mp;
    private final int maxMP;
    private boolean isDefending = false;

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
        System.out.println(ANSI.BLUE + name + ANSI.RESET + " attacks "
                + ANSI.YELLOW + target.getName() + ANSI.RESET + " with "
                + ANSI.CYAN + weapon.getName() + ANSI.RESET + "!");
        target.takeDamage(weapon.getDamage());
    }

    @Override
    public void defend() {
        isDefending = true;
        System.out.println(ANSI.BLUE + name + " raises " + armor.getName() +
                " to defend! Damage will be reduced by 50% next attack." + ANSI.RESET);
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(damage - armor.getDefense(), 0);
        if (isDefending) {
            reducedDamage /= 2;
            System.out.println(ANSI.BLUE + "Defense reduced damage by 50%!" + ANSI.RESET);
        }

        armor.reduceDurability(damage);

        hp -= reducedDamage;
        if (hp < 0) hp = 0;

        System.out.println(ANSI.RED + name + " takes " + reducedDamage +
                " damage! HP: " + hp + "/" + maxHP + ANSI.RESET);
        System.out.println("Armor durability: " + armor.getDurability() + "/" +
                armor.getMaxDurability());

        if (armor.isBroke()) {
            System.out.println(ANSI.RED + ANSI.BOLD + "WARNING: " + armor.getName() +
                    " has broken! Defense is now 0!" + ANSI.RESET);
        }

        isDefending = false;
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
