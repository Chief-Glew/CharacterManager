package com.chiefglew.dndcharacter.config;

import com.chiefglew.dndcharacter.application.items.Wallet;
import com.chiefglew.dndcharacter.application.items.currency.*;
import com.chiefglew.dndcharacter.application.randomGenerators.NumberBetweenUpperAndLowerBoundGenerator;
import com.chiefglew.dndcharacter.application.randomGenerators.UpperBoundLessThanOrEqualToLowerBoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
}
