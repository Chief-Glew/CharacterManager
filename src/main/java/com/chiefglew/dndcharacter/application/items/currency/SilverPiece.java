package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class SilverPiece extends Currency {
    public SilverPiece() {
        super("SilverPiece", "sp", new NullItemUseCommand());
        }

    	@Override
    	protected Item duplicate() {
    		return new SilverPiece();
    	}
}
