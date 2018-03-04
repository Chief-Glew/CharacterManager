package com.chiefglew.dndcharacter.config;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Market;
import com.chiefglew.dndcharacter.application.items.Wallet;
import com.chiefglew.dndcharacter.application.items.currency.*;
import com.chiefglew.dndcharacter.application.items.weapons.ShortSword;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.NumberBetweenUpperAndLowerBoundGenerator;
import com.chiefglew.dndcharacter.application.randomGenerators.UpperBoundLessThanOrEqualToLowerBoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;

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
    public Market smallMarket(ShortSword shortSword){
        Market smallMarket = new Market(new HashMap<Item, Integer>());
        smallMarket.addStock(shortSword, 10);
        return smallMarket;
    }

    @Bean
    public Dice d6(NumberBetweenUpperAndLowerBoundGenerator numberBetweenUpperAndLowerBoundGenerator){
        return new Dice(6, numberBetweenUpperAndLowerBoundGenerator);
    }

    @Bean
    public Dice d20(NumberBetweenUpperAndLowerBoundGenerator numberBetweenUpperAndLowerBoundGenerator){
        return new Dice(20, numberBetweenUpperAndLowerBoundGenerator);
    }
}
