package com.chiefglew.dndcharacter.application.items.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommand;
import com.chiefglew.dndcharacter.application.items.Item;

@Component
@Scope("prototype")
public class ShortSword extends Item implements MartialMeleeWeapon{

	private ItemUseCommand useCommand;
    
	@Autowired
    public ShortSword(ItemUseCommand itemUseCommand){
		this.useCommand = itemUseCommand;
    }

	@Override
	public ItemUseCommand useItem() {
		return this.useCommand;
	}

	@Override
	public int getNumberOfUses() {
		return -1;
	}
	
}
