package com.chiefglew.dndcharacter.application.items.market;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.items.currency.Currency;

@Component
@Scope("prototype")
public class DefaultInventory<T> implements Inventory<T> {

	@Override
	public void addall(Inventory<Currency> goldPieces) {
		// TODO Auto-generated method stub
		
	}

}
