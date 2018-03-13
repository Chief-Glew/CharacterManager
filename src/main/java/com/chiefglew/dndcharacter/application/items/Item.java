package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public abstract class Item implements Usable {
	
	private ItemUseCommand useCommand;
	
	@Override
	public int getNumberOfUses() {
		return -1;
	}

	@Override
	public ItemUseCommand useItem() {
		return this.useCommand;
	}
}
