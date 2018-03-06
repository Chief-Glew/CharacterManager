package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommand;

public interface Usable {

	int getNumberOfUses();

	ItemUseCommand useItem();

}
