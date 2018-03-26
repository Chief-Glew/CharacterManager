package com.chiefglew.dndcharacter.application.items.market;


import java.util.HashMap;
import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public class Market extends GenericMarket<Item, Integer> {
    
	public Market(GenericStock<String, Item, Integer> stock, ValueHandler<Integer> valueHandler) {
        super(stock, valueHandler);
    }

	@Override
	public GenericTrade<Item, Item> buyItem(String itemKey, GenericTrade<Item, Item> trade) throws OutOfStockException {
		
		Map<Valuable, Integer> cost;
		try {
			cost = appraise(itemKey);
		} catch (CouldNotHandleException e) {
			e.printStackTrace(); //TODO log this
			throw new OutOfStockException(itemKey);
		}
		
		if (tradeContainsValuablesToCoverTheCost(trade, cost)){
			//Map<Item, Integer> itemCost = pullIemsFromCostOutOfTrade(trade, cost);
			Map<Item, Integer> selling = trade.getSelling();
			for (Item item : selling.keySet()) {
				stock.addItemToStock(item.getValuableName(), item, selling.get(item));
			}
			trade.setItem(stock.withdrawFromStock(itemKey));
		}

		return trade;
	}
	
	@Deprecated//WIP
	private Map<Item, Integer> pullIemsFromCostOutOfTrade(GenericTrade<Item, Item> trade, Map<Valuable, Integer> cost) {
		Map<Item, Integer> returnMap = new HashMap<Item, Integer>();
		Map<Item, Integer> tradeMap = trade.getSelling();
		for (Valuable itemName : cost.keySet()) {
			int amountToPull = cost.get(itemName);
			int currentAmount = tradeMap.getOrDefault(itemName, 0);
//			tradeMap.
//			tradeMap.put(itemName, currentAmount-amountToPull);
//			returnMap.put(itemName, amountToPull);
		}
		return returnMap;
	}

	private boolean tradeContainsValuablesToCoverTheCost(GenericTrade<Item, Item> trade, Map<Valuable, Integer> cost) {
		Map<Item, Integer> tradeMap = trade.getSelling();
		for (Valuable itemName : cost.keySet()) {
			int amountOfItem = tradeMap.getOrDefault(itemName, 0);
			if (amountOfItem<cost.get(itemName)){
				return false;
			}
		}
		return true;
	}

 

}
