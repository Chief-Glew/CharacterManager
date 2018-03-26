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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
