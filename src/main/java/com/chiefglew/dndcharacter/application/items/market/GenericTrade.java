package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

public interface GenericTrade<ItemBought, ValuableSold> {

	void setItem(ItemBought item);

	ItemBought getItem();

	void removeValuable(ValuableSold valuableSold);

	void addValuableToSell(ValuableSold valuableSold);

	void addValuablesToSell(Map<? extends ValuableSold, Integer> valuablesSold);

}
