package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;

public class ElectrumHandler extends CurrencyStore {
    public ElectrumHandler(int amount) {
        super("ep",2, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException {
        withdrawFromNext(new GoldPiece(requiredAmount));
    }
}
