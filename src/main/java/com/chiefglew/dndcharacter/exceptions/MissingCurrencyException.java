package com.chiefglew.dndcharacter.exceptions;

import com.chiefglew.dndcharacter.application.items.currency.Currency;

import java.util.Arrays;
import java.util.List;

public class MissingCurrencyException extends Throwable {
    private List<Currency> currencies;

    public MissingCurrencyException(List<Currency> currencies) {
        super("The following currencies could not be handled " + currencies);
        this.currencies = currencies;
    }

    public MissingCurrencyException(Currency currency) {
        super("The following currency could not be handled " + currency);
        this.currencies = Arrays.asList(currency);
    }
}
