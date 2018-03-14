package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class NullItem extends Item {

	protected NullItem(ItemBuilder itemBuilder) {
		super(itemBuilder.setUseCommand(new NullItemUseCommand()));
	}

}
