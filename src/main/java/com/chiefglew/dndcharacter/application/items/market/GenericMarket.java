package com.chiefglew.dndcharacter.application.items.market;

import java.util.List;
import java.util.Map;

import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public abstract class GenericMarket<Item extends Valuable, ItemMeasurement>
		implements SellsGenericValuables<Item, ItemMeasurement> {

	private GenericStock<String, Item, ItemMeasurement> stock;
	private GenericHandler<ValueHandler> valueHandler;

	public GenericMarket(GenericStock<String, Item, ItemMeasurement> stock, GenericHandler<ValueHandler> valueHandler) {
		this.stock = stock;
		this.valueHandler = valueHandler;
	}

	@Override
	public void addStock(Item item, ItemMeasurement amount, List<Valuable> cost) {
		stock.addItemToStock(item.getValuableName(), item, amount);
		valueHandler.addToChain(new CustomValueHandler(item.getValuableName(), cost));
	}

	@Override
	public Map<String, ItemMeasurement> getAmountOfItemsInStock() {
		return stock.getAmountOfItemsInStock();
	}

	@Override
	public GenericTrade<Item> buyItem(String itemKey, GenericTrade<Item> trade) throws OutOfStockException {
		Item item = stock.withdrawFromStock(itemKey);
		trade.setItem(item);
		return trade;
	}

	@Override
	public Map<String, ItemMeasurement> appraise(Item item) {
		// TODO Auto-generated method stub
		return null;
	}
}
