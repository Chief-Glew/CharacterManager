package com.chiefglew.dndcharacter.application.items;


import com.chiefglew.dndcharacter.application.items.weapons.ShortSword;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

import java.util.Map;

public class Market {
    private Map<Item, Integer> stock;

    public Market(Map<Item, Integer> stock) {
        this.stock = stock;
    }

    public Trade buyShortSword(Trade trade) throws OutOfStockException {
        Item shortSword = getFromStock(ShortSword.class);
        trade.addItem(shortSword);
        return trade;
    }

    private Item getFromStock(Class<? extends Item> itemClass) throws OutOfStockException {
        Item returnItem = null;
        for (Item item :
                stock.keySet()) {
            if (item.getClass() == itemClass) {
                decreaseStock(item);
                returnItem = item;
            }
            }
        return returnItem;
    }

    private void decreaseStock(Item item) throws OutOfStockException {
        int currentStock = stock.get(item);
        if (currentStock == 0){
            throw new OutOfStockException(item);
        }
        currentStock-=1;
        stock.put(item, currentStock);
    }

    public void addStock(Item item, int amount) {
        stock.put(item, amount);
    }
}
