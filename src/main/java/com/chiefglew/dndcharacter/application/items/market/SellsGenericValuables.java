package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public interface SellsGenericValuables<Item extends Valuable, ItemMeasurement> {

	Map<String, ItemMeasurement> appraise(Item item) throws CouldNotHandleException;

	Map<String, ItemMeasurement> getAmountOfItemsInStock();

	void addStock(Item item, ItemMeasurement amount, Map<String, ItemMeasurement> valuables);

	GenericTrade<Item, Item> buyItem(String itemKey, GenericTrade<Item, Item> trade) throws OutOfStockException;

}
