package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Valuable;
import java.util.List;

public class CustomValueHandler extends ValueHandler {
    public CustomValueHandler(String valuableName, List<Valuable> cost) {
        super(valuableName, cost);
    }
}
