package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;

import java.util.Set;

public class Trade implements GenericTrade<Item>{
    private Set<Valuable> valuables;
    private Item item;

    public Trade(Set<Valuable> valuables, Item item) {
        this.valuables = valuables;
        this.item = item;
    }

    public Trade(Set<Valuable> valuables) {
        this.valuables = valuables;
    }

    @Override
	public void addValuableToSell(Valuable valuable) {
        this.valuables.add(valuable);
    }

    @Override
	public void removeValuable(Valuable valuable){
        this.valuables.remove(valuable);
    }

    @Override
	public Item getItem() {
        return item;
    }

    @Override
	public void setItem(Item item) {
        this.item = item;
    }
}
