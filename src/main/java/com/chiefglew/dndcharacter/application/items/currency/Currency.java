package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;

import java.util.ArrayList;
import java.util.List;

public abstract class Currency extends Item implements Valuable {

    private final String symbol;
    private int amount;

    public Currency(String symbol, int amount) {
        this.symbol = symbol;
        this.amount = amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public List<Currency> getValue() {
        List<Currency> returnList = new ArrayList<Currency>();
        returnList.add(this);
        return returnList;
    }
}
