package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public abstract class Item implements Usable, Valuable {
	
	protected ItemUseCommand useCommand;
	private String name;
	
	public Item(String name, ItemUseCommand useCommand) {
		this.name = name;
		this.useCommand = useCommand;
	}
	
	@Override
	public int getNumberOfUses() {
		return -1;
	}

	@Override
	public ItemUseCommand useItem() {
		return this.useCommand;
	}

	protected abstract Item duplicate();

	public String getName() {
		return name;
	}
}
