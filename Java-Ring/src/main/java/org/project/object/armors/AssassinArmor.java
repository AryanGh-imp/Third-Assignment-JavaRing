package org.project.object.armors;


import org.project.entity.Entity;
import org.project.entity.players.Player;

public class AssassinArmor extends Armor {

    public AssassinArmor() {
        super("Assassin", 5, 75);
    }

    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println("AssassinArmor's armor is broken!");
        }
    }

    @Override
    public String toString() {
        return "AssassinArmor Armor (Defense: " + getDefense() + ", Durability: " + getDurability() + ")";
    }

    @Override
    public int getMaxDurability() {
        return 75;
    }

}