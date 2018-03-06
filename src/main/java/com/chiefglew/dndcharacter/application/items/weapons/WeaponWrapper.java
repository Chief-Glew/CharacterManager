package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommmand;
import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Usable;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

import java.util.List;

@Deprecated
public class WeaponWrapper extends Item implements Weapon {


    private Weapon weapon;
    private Usable item;

    public WeaponWrapper(Usable item) {

        if (item instanceof Weapon){
            weapon = (Weapon)item;
        }
        else{
           // weapon = new ImprovisedWeapon();
        }
        this.item = item;
    }

    public WeaponWrapper(Usable item, Weapon weapon){
        this.item = item;
        this.weapon = weapon;
    }

    @Override
    public List<Dice> getDamage() {
        return weapon.getDamage();
    }

	@Override
	public int getNumberOfUses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemUseCommmand useItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
