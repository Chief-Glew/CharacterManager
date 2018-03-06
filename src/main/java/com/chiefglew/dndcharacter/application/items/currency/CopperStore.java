package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.notEnoughFundsException;

public class CopperStore extends CurrencyStore {
    public CopperStore(int amount) {
        super("cp", 10, amount);
    }

    @Override
    protected void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException, notEnoughFundsException {
        withdrawFromNext(new SilverPiece(requiredAmount));
    }
}
