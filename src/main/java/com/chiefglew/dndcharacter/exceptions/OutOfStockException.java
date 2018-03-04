package com.chiefglew.dndcharacter.exceptions;

import com.chiefglew.dndcharacter.application.items.Item;

public class OutOfStockException extends Throwable {
    private Item item;

    public OutOfStockException(Item item) {
        super("there are no more available " + item);
        this.item = item;
    }
}
