package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Item;

public class ItemTrade implements GenericTrade<Item, Item>{
    private Inventory<Item> selling;
    private Item item;

    public ItemTrade(Inventory<Item> selling) {
        this.selling = selling;
    }

    @Override
	public void addValuableToSell(Item item) {
        this.selling.add(item);
    }

    @Override
	public void removeValuable(Item item){
        this.selling.remove(item);
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
	public void addValuablesToSell(Inventory<? extends Item> items) {
		this.selling.addAll(items);
	}
}
