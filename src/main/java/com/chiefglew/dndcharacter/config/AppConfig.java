package com.chiefglew.dndcharacter.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Market;
import com.chiefglew.dndcharacter.application.items.Wallet;
import com.chiefglew.dndcharacter.application.items.currency.CopperStore;
import com.chiefglew.dndcharacter.application.items.currency.CurrencyStore;
import com.chiefglew.dndcharacter.application.items.currency.ElectrumHandler;
import com.chiefglew.dndcharacter.application.items.currency.GoldHandler;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumHandler;
import com.chiefglew.dndcharacter.application.items.currency.SilverHandler;
import com.chiefglew.dndcharacter.application.items.itemfactory.GetItemHandler;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.NumberBetweenUpperAndLowerBoundGenerator;
import com.chiefglew.dndcharacter.application.randomGenerators.UpperBoundLessThanOrEqualToLowerBoundException;

@Configuration
@ComponentScan(basePackages = {"com.chiefglew.dndcharacter"})
public class AppConfig {

    @Bean
    public NumberBetweenUpperAndLowerBoundGenerator numberBetweenUpperAndLowerBoundGenerator() throws UpperBoundLessThanOrEqualToLowerBoundException {
        return new NumberBetweenUpperAndLowerBoundGenerator(0,1);
    }

    @Bean
    @Scope("prototype")
    public Wallet wallet(){
        CurrencyStore currencyStore = new CopperStore(0);
        currencyStore.addToChain(new SilverHandler(0));
        currencyStore.addToChain(new ElectrumHandler(0));
        currencyStore.addToChain(new GoldHandler(0));
        currencyStore.addToChain(new PlatinumHandler(0));
        Wallet wallet = new Wallet(currencyStore);
        return wallet;
    }
    
    @Bean
    public Map<Integer, Dice> diceMap(){
    	return new ConcurrentHashMap<Integer, Dice>();
    }

    @Bean
    @Scope("prototype")
    public Market smallMarket(ItemFactory itemFactory){
        Market smallMarket = new Market(new HashMap<Item, Integer>());
        smallMarket.addStock(itemFactory.getItem("shortSword"), 10);
        return smallMarket;
    }
    
    @Bean
    public ItemFactory getItemFactory(List<GetItemHandler> getItemHandlers){
    	GetItemHandler head = getItemHandlers.get(0);
    	getItemHandlers.remove(head);
    	for (GetItemHandler getItemHandler : getItemHandlers) {
			head.addToChain(getItemHandler);
		}
    	return new ItemFactory(head);
    }
}
