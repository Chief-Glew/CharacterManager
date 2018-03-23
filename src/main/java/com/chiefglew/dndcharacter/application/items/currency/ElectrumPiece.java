package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.NullItemUseCommand;

public class ElectrumPiece extends Currency {
    public ElectrumPiece() {
        super("ElectrumPiece", "ep", new NullItemUseCommand());
        }

    	@Override
    	protected Item duplicate() {
    		return new ElectrumPiece();
    	}
}
