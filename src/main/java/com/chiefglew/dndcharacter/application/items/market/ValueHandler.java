package com.chiefglew.dndcharacter.application.items.market;

import java.util.List;

import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public class ValueHandler extends GenericHandler<ValueHandler> {
    private final String valuableName;
    private final List<Valuable> cost;

    public ValueHandler(String valuableName, List<Valuable> cost) {
        this.valuableName = valuableName;
        this.cost = cost;
    }

    public List<Valuable> handle(String valuableName) throws CouldNotHandleException {
        if (valuableName.equals(this.valuableName)){
            return handlerMethod();
        }
        else{
            return handleNext(valuableName);
        }
    }

    protected List<Valuable> handlerMethod() {
        return cost;
    }

    protected List<Valuable> handleNext(String valuableName) throws CouldNotHandleException {
        if (!isNextNull()){
            return next.handle(valuableName);
        }
        else {
            throw new CouldNotHandleException("no value found for " + valuableName);
        }
    }
}
