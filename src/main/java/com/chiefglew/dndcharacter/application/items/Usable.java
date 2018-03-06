package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommmand;

public interface Usable {

	int getNumberOfUses();

	ItemUseCommmand useItem();

}
