package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

import java.util.List;

public class DoNothingValueHandler extends ValueHandler {

    public DoNothingValueHandler() {
        super("", null);
    }

    @Override
    public List<Currency> handle(String valuableName) throws CouldNotHandleException {
        return handleNext(valuableName);
    }

}
