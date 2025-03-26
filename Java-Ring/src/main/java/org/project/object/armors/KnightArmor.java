package org.project.object.armors;


import org.project.ANSI;
import org.project.entity.Entity;
import org.project.entity.players.Player;

public class KnightArmor extends Armor {

    public KnightArmor() {
        super("KnightArmor", 7, 50);
    }

    @Override
    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println(ANSI.RED + "Knight Armor has shattered!" + ANSI.RESET);
        }
    }

    @Override
    public String toString() {
        return "Knight Armor (Defense: " + getDefense() + ", Durability: " + getDurability() + ")";
    }

    @Override
    public int getMaxDurability() {
        return 50;
    }

}