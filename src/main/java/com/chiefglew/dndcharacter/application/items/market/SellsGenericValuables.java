package com.chiefglew.dndcharacter.application.items.market;

import java.util.List;
import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public interface SellsGenericValuables<Item extends Valuable, ItemMeasurement> {

	Map<String, ItemMeasurement> appraise(Item item);

	Map<String, ItemMeasurement> getAmountOfItemsInStock();

	void addStock(Item item, ItemMeasurement amount, List<Valuable> cost);

	GenericTrade<Item> buyItem(String itemKey, GenericTrade<Item> trade) throws OutOfStockException;

}
