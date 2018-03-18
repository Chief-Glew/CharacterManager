package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

import java.util.List;

public class ValueHandler extends GenericHandler<ValueHandler> {
    private final String valuableName;
    private final List<Currency> cost;

    public ValueHandler(String valuableName, List<Currency> cost) {
        this.valuableName = valuableName;
        this.cost = cost;
    }

    public List<Currency> handle(String valuableName) throws CouldNotHandleException {
        if (valuableName.equals(this.valuableName)){
            return handlerMethod();
        }
        else{
            return handleNext(valuableName);
        }
    }

    protected List<Currency> handlerMethod() {
        return cost;
    }

    private List<Currency> handleNext(String valuableName) throws CouldNotHandleException {
        if (!isNextNull()){
            return next.handle(valuableName);
        }
        else {
            throw new CouldNotHandleException("no value found for " + valuableName);
        }
    }
}
