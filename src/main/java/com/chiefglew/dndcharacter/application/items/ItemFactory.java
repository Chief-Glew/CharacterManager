package com.chiefglew.dndcharacter.application.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;
import com.chiefglew.dndcharacter.application.items.weapons.SimpleWeapon;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

@Configurable
public class ItemFactory {
	
	@Autowired
	private ItemUseCommand itemUseCommand;
	@Autowired
	private ItemBuilderHandler itemBuilderHandler;
	
	
	@Autowired
	public ItemFactory(ItemUseCommand itemUseCommand, ItemBuilderHandler itemBuilderHandler) {
		this.itemUseCommand = itemUseCommand;
		this.itemBuilderHandler = itemBuilderHandler;
	}



	public SimpleWeapon getSimpleWeapon(String type, String Description, List<Dice> damage) {
		
		return SimpleWeapon.;		
	}

}
