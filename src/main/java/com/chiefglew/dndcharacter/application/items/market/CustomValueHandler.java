package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.currency.Currency;

import java.util.List;

public class CustomValueHandler extends ValueHandler {
    public CustomValueHandler(String valuableName, List<Currency> cost) {
        super(valuableName, cost);
    }
}
