package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class CopperPiece extends Currency {
   
	public CopperPiece() {
        super("CopperPiece", "cp", new NullItemUseCommand());
    }

	@Override
	protected Item duplicate() {
		return new CopperPiece();
	}

}
