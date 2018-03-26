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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	
	
}
