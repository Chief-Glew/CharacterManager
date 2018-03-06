package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.notEnoughFundsException;

public class GoldHandler extends CurrencyStore {
    public GoldHandler(int amount) {
        super("gp", 10, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException, notEnoughFundsException {
        withdrawFromNext(new PlatinumPiece(requiredAmount));
    }
}
