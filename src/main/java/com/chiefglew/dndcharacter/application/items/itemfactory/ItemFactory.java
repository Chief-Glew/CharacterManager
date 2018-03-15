package com.chiefglew.dndcharacter.application.items.itemfactory;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class ItemFactory {
	
	private GetItemFromStringHandler itemFromStringHandler;
	

	public ItemFactory(GetItemFromStringHandler itemFromStringHandler) {
		this.itemFromStringHandler = itemFromStringHandler;
	}

	public Item getItem(String name) {
		Item returnItem = null;
		try {
			returnItem = itemFromStringHandler.handle(name);
		} catch (CouldNotHandleException e) {
			e.printStackTrace();
		}
		return returnItem;
	}



}
