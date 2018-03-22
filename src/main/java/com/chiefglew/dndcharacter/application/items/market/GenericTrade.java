package com.chiefglew.dndcharacter.application.items.market;

public interface GenericTrade<ItemBought, ValuableSold> {

	void setItem(ItemBought item);

	ItemBought getItem();

	void removeValuable(ValuableSold valuableSold);

	void addValuableToSell(ValuableSold valuableSold);

	void addValuablesToSell(Inventory<? extends ValuableSold> valuablesSold);

}
