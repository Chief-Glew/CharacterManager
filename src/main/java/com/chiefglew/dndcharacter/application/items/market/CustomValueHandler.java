package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

public class CustomValueHandler<ValuableAmount> extends ValueHandler<ValuableAmount> {
    public CustomValueHandler(String valuableName, Map<String, ValuableAmount> cost) {
        super(valuableName, cost);
    }
}
