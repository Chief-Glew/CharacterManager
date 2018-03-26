package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;

public class CustomValueHandler<ValuableAmount> extends ValueHandler<ValuableAmount> {
    public CustomValueHandler(String valuableName, Map<Valuable, ValuableAmount> cost) {
        super(valuableName, cost);
    }
}
