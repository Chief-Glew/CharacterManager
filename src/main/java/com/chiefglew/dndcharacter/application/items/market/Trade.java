package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trade {
    private Set<Valuable> valuables;
    private Item item;

    public Trade(Set<Valuable> valuables, Item item) {
        this.valuables = valuables;
        this.item = item;
    }

    public Trade(Set<Valuable> valuables) {
        this.valuables = valuables;
    }

    public void addValuableToSell(Valuable valuable) {
        this.valuables.add(valuable);
    }

    public void removeValuable(Valuable valuable){
        this.valuables.remove(valuable);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
