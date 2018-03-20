package com.chiefglew.dndcharacter.application.items.market;


import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Item;

public class Market extends GenericMarket<Item, Integer> {
    
	public Market(GenericStock<String, Item, Integer> stock, GenericHandler<ValueHandler> valueHandler) {
        super(stock, valueHandler);
    }

 

}
