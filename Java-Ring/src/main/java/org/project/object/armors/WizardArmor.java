package org.project.object.armors;


import org.project.entity.Entity;
import org.project.entity.players.Player;

public class WizardArmor extends Armor {

    public WizardArmor() {
        super("WizardArmor", 3, 100);
    }

    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println("Wizard's armor is broken!");
        }
    }

    @Override
    public String toString() {
        return "Wizard Armor (Defense: " + getDefense() + ", Durability: " + getDurability() + ")";
    }

    @Override
    public int getMaxDurability() {
        return 100;
    }

}