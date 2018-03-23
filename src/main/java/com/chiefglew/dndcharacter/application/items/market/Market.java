package com.chiefglew.dndcharacter.application.items.market;


import java.util.HashMap;
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
			e.printStackTrace(); //TODO log this
			throw new OutOfStockException(itemKey);
		}
		
		if (tradeContainsValuablesToCoverTheCost(trade, cost)){
			Map<Item, Integer> itemCost = pullIemsFromCostOutOfTrade(trade, cost);
			for (Item item : itemCost.keySet()) {
				stock.addItemToStock(item.getValuableName(), item, itemCost.get(item));
			}
			trade.setItem(stock.withdrawFromStock(itemKey));
		}

		return trade;
	}

	private Map<Item, Integer> pullIemsFromCostOutOfTrade(GenericTrade<Item, Item> trade, Map<String, Integer> cost) {
		Map<Item, Integer> returnMap = new HashMap<Item, Integer>();
		
		return returnMap;
	}

	private boolean tradeContainsValuablesToCoverTheCost(GenericTrade<Item, Item> trade, Map<String, Integer> cost) {
		
		return false;
	}

 

}
