package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.notEnoughFundsException;

public class SilverHandler extends CurrencyStore {
    public SilverHandler(int amount) {
        super("sp", 5, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException, notEnoughFundsException {
        withdrawFromNext(new ElectrumPiece(requiredAmount));
    }
}
