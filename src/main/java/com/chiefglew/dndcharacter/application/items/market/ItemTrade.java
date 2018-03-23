package com.chiefglew.dndcharacter.application.items.market;

import java.util.Map;

import com.chiefglew.dndcharacter.application.items.Item;

public class ItemTrade implements GenericTrade<Item, Item>{
    private Map<Item, Integer> selling;
    private Item item;

    public ItemTrade(Map<Item, Integer> selling) {
        this.selling = selling;
    }

    @Override
	public void addValuableToSell(Item item) {
    	int current = selling.getOrDefault(item, 0);
        selling.put(item, current+1);
    }

    @Override
	public void removeValuable(Item item){
    	if(selling.containsKey(item)){
    		int current = selling.getOrDefault(item, 0);
    		selling.put(item, current-1);
    		if (current <= 0){
    			selling.remove(item);
    		}
    	}
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
	public void addValuablesToSell(Map<? extends Item, Integer> items) {
		this.selling.putAll(items);
	}
}
