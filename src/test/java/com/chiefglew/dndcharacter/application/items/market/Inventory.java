package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.currency.Currency;

public interface Inventory<T> {

	void addall(Inventory<Currency> goldPieces);

}
