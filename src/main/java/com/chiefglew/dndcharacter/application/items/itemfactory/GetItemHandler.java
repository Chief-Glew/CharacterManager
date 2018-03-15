package com.chiefglew.dndcharacter.application.items.itemfactory;

import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public abstract class GetItemHandler extends GenericHandler<GetItemHandler> implements GetItemFromStringHandler {

	private String name;

	public GetItemHandler(String name) {
		this.name = name;
	}
	
	@Override
	public Item handle(String name) throws CouldNotHandleException {
		if (name.equals(this.name)){
		return handlerMethod();
		}
		else{
			return handleNext(name);
		}
	}

	protected abstract Item handlerMethod();

	private Item handleNext(String name) throws CouldNotHandleException {
		if (!isNextNull()){
			return next.handle(name);
		}
		else{
			throw new CouldNotHandleException(name + "could not be returned by this chain of handlers");
		}
	}
}
