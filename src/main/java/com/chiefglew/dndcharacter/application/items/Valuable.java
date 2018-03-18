package com.chiefglew.dndcharacter.application.items;

public interface Valuable {

    default String getValuableName(){
        return this.getClass().getSimpleName();
    }
}
