package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class GoldPiece extends Currency {
    public GoldPiece() {
        super("GoldPiece", "gp", new NullItemUseCommand());
        }

    	@Override
    	protected Item duplicate() {
    		return new GoldPiece();
    	}
    	
    	
}
