package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public interface SellsGenericValuables<Item extends Valuable, ItemMeasurement> {

	Map<String, ItemMeasurement> getAmountOfItemsInStock();

	void addStock(Item item, ItemMeasurement amount, Map<Valuable, ItemMeasurement> valuables);

	GenericTrade<Item, Item> buyItem(String itemKey, GenericTrade<Item, Item> trade) throws OutOfStockException;

	Map<Valuable, ItemMeasurement> appraise(String item) throws CouldNotHandleException;

	Map<Valuable, ItemMeasurement> appraise(Item item) throws CouldNotHandleException;
}
