package org.project.object.armors;


public class KnightArmor extends Armor {
    private final String armorType;
    private int additionalDefense; //Additional defense against specific attacks or other features

    public KnightArmor(int defense, int durability, String armorType) {
        super(defense, durability);
        this.armorType = armorType;
        this.additionalDefense = 0;  // default
    }

    public void increaseDefense(int amount) {
        this.additionalDefense += amount;
    }

    public void checkBreak() {
        super.checkBreak();
        if (isBroke()) {
            System.out.println("Knight's armor is broken!");
        }
    }

    // Method to get the total armor defense (including main defense and additional defense)
    @Override
    public int getDefense() {
        return super.getDefense() + additionalDefense;
    }

    public String getArmorType() {
        return armorType;
    }

    // Method for resetting additional defense
    public void resetDefense() {
        this.additionalDefense = 0;
    }
}