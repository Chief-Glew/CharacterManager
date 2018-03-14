package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.items.Item;

public class MartialWeapon extends Weapon  {

	protected MartialWeapon(ItemBuilder itemBuilder) {
		super(itemBuilder);
	}

	protected static Item getInstance(ItemBuilder itemBuilder) {
		return new MartialWeapon(itemBuilder);
	}

	
	
	
}
