package com.chiefglew.dndcharacter.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chiefglew.dndcharacter.application.items.currency.*;
import com.chiefglew.dndcharacter.application.items.market.DefaultItemStock;
import com.chiefglew.dndcharacter.application.items.market.DoNothingValueHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.market.Market;
import com.chiefglew.dndcharacter.application.items.Wallet;
import com.chiefglew.dndcharacter.application.items.itemfactory.GetItemHandler;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.NumberBetweenUpperAndLowerBoundGenerator;
import com.chiefglew.dndcharacter.application.randomGenerators.UpperBoundLessThanOrEqualToLowerBoundException;

@Configuration
@ComponentScan(basePackages = {"com.chiefglew.dndcharacter.application"})
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
        Market smallMarket = new Market(new DefaultItemStock(new HashMap<>(), new HashMap<>()), new DoNothingValueHandler());
        List<Currency> cost = new ArrayList<>();
        cost.add(new GoldPiece(20));
        smallMarket.addStock(itemFactory.getItem("ShortSword"), 10, cost);
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
