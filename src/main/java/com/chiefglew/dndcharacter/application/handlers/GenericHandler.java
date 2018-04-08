package com.chiefglew.dndcharacter.application.handlers;


import com.chiefglew.dndcharacter.ListLinker;

public abstract class GenericHandler<T extends ListLinker<T>> implements ListLinker<T> {

    protected T next;


    @Override
    public T addToChain(T handler) {
        if (next==null) {
            next = handler;
        }
        else {
            next.addToChain(handler);
        }
        return next;
    }

    protected boolean isNextNull() {
        return next==null;
    }
}
