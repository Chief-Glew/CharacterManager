package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class PlatinumPiece extends Currency {
    public PlatinumPiece() {
        super("PlatinumPiece", "pp", new NullItemUseCommand());
        }

    	@Override
    	protected Item duplicate() {
    		return new PlatinumPiece();
    	}

}
