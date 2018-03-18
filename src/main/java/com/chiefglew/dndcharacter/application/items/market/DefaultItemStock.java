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
        return null;
    }

    @Override
    public Integer getAmountOfItem(String s) {
        return null;
    }

    @Override
    public void addItemToStock(String s, Item item, Integer integer) {

    }

    @Override
    public Set<String> getItemsInStock() {
        return null;
    }
}
