package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

import java.util.List;

public class WeaponWrapper extends Item implements Weapon {


    private Weapon weapon;
    private Item item;

    public WeaponWrapper(Item item) {

        if (item instanceof Weapon){
            weapon = (Weapon)item;
        }
        else{
            weapon = new ImprovisedWeapon();
        }
        this.item = item;
    }

    public WeaponWrapper(Item item, Weapon weapon){
        this.item = item;
        this.weapon = weapon;
    }

    @Override
    public List<Dice> getDamage() {
        return weapon.getDamage();
    }
}
