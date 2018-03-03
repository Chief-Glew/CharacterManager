package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;

public class SilverHandler extends CurrencyStore {
    public SilverHandler(int amount) {
        super("sp", 5, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException {
        withdrawFromNext(new ElectrumPiece(requiredAmount));
    }
}
