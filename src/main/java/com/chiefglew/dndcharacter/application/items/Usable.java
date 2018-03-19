package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public interface Usable {
	
	int getNumberOfUses();

	ItemUseCommand useItem();

}
