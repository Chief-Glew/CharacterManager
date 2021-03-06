package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public class ShortSword extends MartialWeapon{

	public ShortSword(ItemUseCommand useCommand) {
		super("ShortSword", useCommand);
	}

	@Override
	protected Item duplicate() {
		return new ShortSword(useCommand);
	}


}
