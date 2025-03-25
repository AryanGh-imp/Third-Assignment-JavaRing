package org.project.object.armors;


import org.project.entity.Entity;
import org.project.entity.players.Player;

public class AssassinArmor extends Armor {

    public AssassinArmor() {
        super("Assassin", 10, 75);
    }

    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println("AssassinArmor's armor is broken!");
        }
    }

    @Override
    public void use(Entity target) {
        if (target instanceof Player) {
            ((Player) target).setArmor(this);
            System.out.println("You have equipped AssassinArmor Armor.");
        } else {
            System.out.println("INVALID!");
        }
    }

    @Override
    public String toString() {
        return "AssassinArmor Armor (Defense: " + getDefense() + ", Durability: " + getDurability() + ")";
    }

}