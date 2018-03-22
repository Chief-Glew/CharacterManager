package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;

import java.util.Set;

public class ItemTrade implements GenericTrade<Item, Valuable>{
    private Inventory<? extends Item> selling;
    private Item item;

    public ItemTrade(Inventory<? extends Item> selling) {
        this.selling = selling;
    }

    @Override
	public void addValuableToSell(Valuable valuable) {
        this.selling.add(valuable);
    }

    @Override
	public void removeValuable(Valuable valuable){
        this.selling.remove(valuable);
    }

    @Override
	public Item getItem() {
        return item;
    }

    @Override
	public void setItem(Item item) {
        this.item = item;
    }

	@Override
	public void addValuablesToSell(Inventory<? extends Valuable> items) {
		// TODO Auto-generated method stub
		
	}
}
