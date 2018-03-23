package com.chiefglew.dndcharacter.application.items.market;


import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public class Market extends GenericMarket<Item, Integer> {
    
	public Market(GenericStock<String, Item, Integer> stock, ValueHandler<Integer> valueHandler) {
        super(stock, valueHandler);
    }

	@Override
	public GenericTrade<Item, Item> buyItem(String itemKey, GenericTrade<Item, Item> trade) throws OutOfStockException {
		Map<String, Integer> cost;
		try {
			cost = appraise(itemKey);
		} catch (CouldNotHandleException e) {
			e.printStackTrace();
			throw new OutOfStockException(itemKey);
		}
		Map<Item, Integer> selling = trade.getSelling();
		
		for (Item item : selling.keySet()) {
			stock.addItemToStock(item.getValuableName(), item, selling.get(item));
		}
		trade.setItem(stock.withdrawFromStock(itemKey));
		return trade;
	}

 

}
