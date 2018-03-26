package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public abstract class GenericMarket<Item extends Valuable, ItemMeasurement>
		implements SellsGenericValuables<Item, ItemMeasurement> {

	protected GenericStock<String, Item, ItemMeasurement> stock;
	private ValueHandler<ItemMeasurement> valueHandler;

	public GenericMarket(GenericStock<String, Item, ItemMeasurement> stock, ValueHandler<ItemMeasurement> valueHandler) {
		this.stock = stock;
		this.valueHandler = valueHandler;
	}

	@Override
	public void addStock(Item item, ItemMeasurement amount, Map<Valuable, ItemMeasurement> cost) {
		stock.addItemToStock(item.getValuableName(), item, amount);
		valueHandler.addToChain(new CustomValueHandler<ItemMeasurement>(item.getValuableName(), cost));
	}

	@Override
	public Map<String, ItemMeasurement> getAmountOfItemsInStock() {
		return stock.getAmountOfItemsInStock();
	}

	@Override
	public Map<Valuable, ItemMeasurement> appraise(Item item) throws CouldNotHandleException {
		return valueHandler.handle(item.getValuableName());
	}
	
	@Override
	public Map<Valuable, ItemMeasurement> appraise(String item) throws CouldNotHandleException {
		return valueHandler.handle(item);
	}
}
