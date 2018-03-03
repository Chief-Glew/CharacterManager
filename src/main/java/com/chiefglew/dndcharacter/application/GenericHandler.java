package com.chiefglew.dndcharacter.application;


public abstract class GenericHandler<T extends GenericHandler<T>> {

    protected T next;


    public void addToChain(T handler) {
        if (next==null) {
            next = handler;
        }
        else {
            next.addToChain(handler);
        }
    }

    protected boolean isNextNull() {
        return next==null;
    }
}
