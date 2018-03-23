package com.chiefglew.dndcharacter.application.items.currency.currencyhandlers;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.notEnoughFundsException;

public class PlatinumHandler extends CurrencyStore {
    public PlatinumHandler(int amount) {
        super("pp", 10, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException, notEnoughFundsException {
        throw new notEnoughFundsException();
    }
}
