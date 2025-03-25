package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

public class Sword extends Weapon {


    public Sword(String name, int damage, int manaCost) {
        super(name, damage, manaCost, "Sword");
    }

    public void use(Entity target) {
        super.use(target);
    }

}
