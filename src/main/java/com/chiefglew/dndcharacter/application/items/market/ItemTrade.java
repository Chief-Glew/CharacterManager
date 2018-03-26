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
        int amount = 1;
    	addAmountOfItemToSell(item, amount);
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
		for (Item item : items.keySet()) {
			addAmountOfItemToSell(item, items.get(item));
		}
	}

	@Override
	public Map<Item, Integer> getSelling() {
		return selling;
	}

	private void addAmountOfItemToSell(Item item, int amount) {
		int current = selling.getOrDefault(item, 0);
		selling.put(item, current+amount);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((selling == null) ? 0 : selling.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemTrade other = (ItemTrade) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (selling == null) {
			if (other.selling != null)
				return false;
		} else if (!selling.equals(other.selling))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemTrade [selling=");
		builder.append(selling);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
