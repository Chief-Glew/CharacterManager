package com.chiefglew.dndcharacter.application.items.weapons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Item.ItemBuilder;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

@Component
@Scope("prototype")
public class ShortSword extends MartialWeapon{

	protected ShortSword(ItemBuilder itemBuilder) {
		super(itemBuilder);
	}
	
	protected static Item getInstance(ItemBuilder itemBuilder) {
		return new ShortSword(itemBuilder);
	}
}
