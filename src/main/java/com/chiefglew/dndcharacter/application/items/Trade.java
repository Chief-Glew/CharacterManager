package com.chiefglew.dndcharacter.application.items;

import java.util.List;
import java.util.Set;

public class Trade {
    private Set<Valuable> valuables;
    private List<Item> items;

    public Trade(Set<Valuable> valuables, List<Item> items) {
        this.valuables = valuables;
        this.items = items;
    }

    public void addValuableToSell(Valuable valuable) {
        this.valuables.add(valuable);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
