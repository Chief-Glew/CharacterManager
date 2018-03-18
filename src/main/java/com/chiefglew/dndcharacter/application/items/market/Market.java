package com.chiefglew.dndcharacter.application.items.market;


import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

import java.util.List;
import java.util.Map;

public class Market {
    private GenericStock<String, Item, Integer> stock;
    private GenericHandler<ValueHandler> valueHandler;

    public Market(GenericStock<String, Item, Integer> stock, GenericHandler<ValueHandler> valueHandler) {
        this.stock = stock;
        this.valueHandler = valueHandler;
    }

    public Trade buyItem(String itemKey, Trade trade) throws OutOfStockException {
        Item item = stock.withdrawFromStock(itemKey);
        trade.setItem(item);
        return trade;
    }
    
    public void addStock(Item item, int amount, List<Currency> cost) {
        stock.addItemToStock(item.getValuableName(), item, amount);
        valueHandler.addToChain(new CustomValueHandler(item.getValuableName(), cost));
    }

    public Map<String, Integer> getAmountOfItemsInStock() {
        return stock.getAmountOfItemsInStock();
    }
}
