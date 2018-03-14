package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.Item.ItemBuilder;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public abstract class Item implements Usable {
	
	private ItemUseCommand useCommand;
	
	protected Item(ItemBuilder itemBuilder) {
		this.useCommand = itemBuilder.useCommand;
	}

	@Override
	public int getNumberOfUses() {
		return -1;
	}

	@Override
	public ItemUseCommand useItem() {
		return this.useCommand;
	}
	
	public static class ItemBuilder{
		private ItemUseCommand useCommand;
		
		public ItemBuilder setUseCommand(ItemUseCommand useCommand) {
			this.useCommand = useCommand;
			return this;
		}
		
		public Item getItem(){
			return getInstance(this);
		}
	}
	
	protected static Item getInstance(ItemBuilder itemBuilder) {
		return new NullItem(itemBuilder);
	}
}
