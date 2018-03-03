package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.application.items.currency.CurrencyStore;
import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;

public class Wallet {

    private CurrencyStore currencyStore;

    public Wallet(CurrencyStore currencyStore) {
        this.currencyStore = currencyStore;
    }

    public void addFunds(Currency currency) throws MissingCurrencyException {
        currencyStore.deposit(currency);
    }
}
