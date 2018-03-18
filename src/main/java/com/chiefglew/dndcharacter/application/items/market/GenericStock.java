package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

import java.util.Set;

public interface GenericStock<ItemKey, Item, Amount> {
    Item withdrawFromStock(ItemKey key) throws OutOfStockException;
    Amount getAmountOfItem(ItemKey key);
    void addItemToStock(ItemKey key, Item item, Amount amount);
    Set<ItemKey> getItemsInStock();
}
