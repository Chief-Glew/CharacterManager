package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;

public class GoldHandler extends CurrencyStore {
    public GoldHandler(int amount) {
        super("gp", 10, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException {
        withdrawFromNext(new PlatinumPiece(requiredAmount));
    }
}
