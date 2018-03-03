package com.chiefglew.dndcharacter.application.items.currency;

public abstract class Currency {

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
}
