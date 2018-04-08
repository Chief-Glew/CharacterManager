package com.chiefglew.dndcharacter;

public interface ListLinker<T extends ListLinker> {
    T addToChain(T handler);
}
