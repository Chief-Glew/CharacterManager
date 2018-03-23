package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;

public abstract class Currency extends Item {

    private final String symbol;

    public Currency(String name, String symbol, ItemUseCommand useCommand) {
    	super(name, useCommand);
        this.symbol = symbol;
    }

	public String getSymbol() {
        return symbol;
    }

}
