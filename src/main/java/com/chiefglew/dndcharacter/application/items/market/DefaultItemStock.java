package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

import java.util.Map;
import java.util.Set;

public class DefaultItemStock implements GenericStock<String,Item, Integer> {
    private Map<String, Item> items;
    private Map<String, Integer> amounts;

    public DefaultItemStock(Map<String, Item> items, Map<String, Integer> amounts) {
        this.items = items;
        this.amounts = amounts;
    }

    @Override
    public Item withdrawFromStock(String s) throws OutOfStockException {
        reduceAmountByOne(s);
        return items.get(s).duplicate();
    }

    private void reduceAmountByOne(String s) throws OutOfStockException {
        int amount = amounts.get(s);
        if (amount==0)
            throw new OutOfStockException(items.get(s));
        amount-=1;
        amounts.put(s,amount);
    }

    @Override
    public Integer getAmountOfItem(String s) {
        return amounts.get(s);
    }

    @Override
    public void addItemToStock(String s, Item item, Integer integer) {
        items.put(s,item);
        amounts.put(s,integer);
    }

    @Override
    public Set<String> getItemsInStock() {
        return items.keySet();
    }

    @Override
    public Map<String, Integer> getAmountOfItemsInStock() {
        return amounts;
    }
}
