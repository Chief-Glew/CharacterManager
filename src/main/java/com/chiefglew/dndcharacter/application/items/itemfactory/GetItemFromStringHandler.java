package com.chiefglew.dndcharacter.application.items.itemfactory;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public interface GetItemFromStringHandler {

	Item handle(String name) throws CouldNotHandleException;
}
