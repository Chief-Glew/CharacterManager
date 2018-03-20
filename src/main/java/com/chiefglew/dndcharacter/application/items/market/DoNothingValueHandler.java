package com.chiefglew.dndcharacter.application.items.market;

import java.util.List;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class DoNothingValueHandler extends ValueHandler {

    public DoNothingValueHandler() {
        super("", null);
    }

    @Override
    public List<Valuable> handle(String valuableName) throws CouldNotHandleException {
        return handleNext(valuableName);
    }

}
