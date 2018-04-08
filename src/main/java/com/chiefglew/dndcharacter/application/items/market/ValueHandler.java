package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.handlers.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class ValueHandler<ValuableAmount> extends GenericHandler<ValueHandler<ValuableAmount>> {
    private final String valuableName;
    private final Map<Valuable, ValuableAmount> cost;

    public ValueHandler(String valuableName, Map<Valuable, ValuableAmount> cost) {
        this.valuableName = valuableName;
        this.cost = cost;
    }

    public Map<Valuable, ValuableAmount> handle(String valuableName) throws CouldNotHandleException {
        if (valuableName.equals(this.valuableName)){
            return handlerMethod();
        }
        else{
            return handleNext(valuableName);
        }
    }

    protected Map<Valuable, ValuableAmount> handlerMethod() {
        return cost;
    }

    protected Map<Valuable, ValuableAmount> handleNext(String valuableName) throws CouldNotHandleException {
        if (!isNextNull()){
            return next.handle(valuableName);
        }
        else {
            throw new CouldNotHandleException("no value found for " + valuableName);
        }
    }
}
