package org.project.object.armors;


import org.project.entity.Entity;
import org.project.entity.players.Player;

public class KnightArmor extends Armor {

    public KnightArmor() {
        super("KnightArmor", 7, 50);
    }

    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println("Knight's armor is broken!");
        }
    }

    @Override
    public void use(Entity target) {
        if (target instanceof Player) {
            ((Player) target).setArmor(this);
            System.out.println("You have equipped Knight Armor.");
        } else {
            System.out.println("INVALID!");
        }
    }

    @Override
    public String toString() {
        return "Knight Armor (Defense: " + getDefense() + ", Durability: " + getDurability() + ")";
    }

}