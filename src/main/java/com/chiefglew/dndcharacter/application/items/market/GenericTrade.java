package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Valuable;

public interface GenericTrade<Item> {

	void setItem(Item item);

	Item getItem();

	void removeValuable(Valuable valuable);

	void addValuableToSell(Valuable valuable);

}
