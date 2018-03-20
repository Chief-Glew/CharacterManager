package com.chiefglew.dndcharacter.exceptions;

import com.chiefglew.dndcharacter.application.items.Usable;

public class OutOfStockException extends Throwable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usable item;

    public OutOfStockException(Usable item) {
        super("there are no more available " + item);
        this.item = item;
    }
}
