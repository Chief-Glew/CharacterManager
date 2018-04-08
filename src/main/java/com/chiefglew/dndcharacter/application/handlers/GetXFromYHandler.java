package com.chiefglew.dndcharacter.application.handlers;

import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;

public interface GetXFromYHandler<X,Y> {
    X handle(Y y) throws CouldNotHandleException;

    X handleNext(Y y) throws CouldNotHandleException;

    X handlerMethod(Y y);

}
