package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class DoNothingValueHandler<ValuableAmount> extends ValueHandler<ValuableAmount> {

    public DoNothingValueHandler() {
        super("", null);
    }

    @Override
    public Map<Valuable, ValuableAmount> handle(String valuableName) throws CouldNotHandleException {
        return handleNext(valuableName);
    }

}
