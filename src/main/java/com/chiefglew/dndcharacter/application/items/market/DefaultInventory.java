package com.chiefglew.dndcharacter.application.items.market;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DefaultInventory<T> implements Inventory<T> {

	@Override
	public void addAll(Inventory<? extends T> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T t) {
		// TODO Auto-generated method stub
		
	}

}
