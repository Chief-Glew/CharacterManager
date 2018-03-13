package com.chiefglew.dndcharacter.application.randomGenerators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Configurable
public class FairDiceFactory implements DiceFactory {

	@Autowired
    private NumberGenerator numberGenerator;
	@Autowired
	private Map<Integer, Dice> diceMap;
    
    public FairDiceFactory(){}
    
    
    @Override
	public Dice getDiceWithNumberOfSides(int NumberOfSides){
    	return diceMap.computeIfAbsent(NumberOfSides, k -> new Dice(NumberOfSides, numberGenerator));
    }


	@Override
	@Bean
	@Qualifier("d2")
	public Dice getD2() {
        return getDiceWithNumberOfSides(2);

	}


	@Override
	@Bean
	@Qualifier("d4")
	public Dice getD4() {
        return getDiceWithNumberOfSides(4);

	}
	
	@Override
	@Bean
	@Qualifier("d6")
    public Dice getD6() {
        return getDiceWithNumberOfSides(6);
    }


	@Override
	@Bean
	@Qualifier("d8")
	public Dice getD8() {
        return getDiceWithNumberOfSides(8);

	}


	@Override
	@Bean
	@Qualifier("d10")
	public Dice getD10() {
        return getDiceWithNumberOfSides(10);

	}


	@Override
	@Bean
	@Qualifier("d20")
	public Dice getD20() {
        return getDiceWithNumberOfSides(20);

	}
    
}
