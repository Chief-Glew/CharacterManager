package com.chiefglew.dndcharacter.application.randomGenerators;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FairDiceFactory implements DiceFactory {

    private NumberGenerator numberGenerator;
	private Map<Integer, Dice> diceMap;

    private FairDiceFactory(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
        this.diceMap = new ConcurrentHashMap<Integer, Dice>();
    }
    
    public static DiceFactory getInstance(){
    	return DiceFactoryInstanceHolder.INSTANCE;
    }
    
    @Override
	@Bean
    public Dice getD6() {
        return getDiceOrMakeNew(6);
    }
    
    public Dice getDiceOrMakeNew(int NumberOfSides){
    	return diceMap.computeIfAbsent(NumberOfSides, k -> new Dice(NumberOfSides, numberGenerator));
    }
    
    private static class DiceFactoryInstanceHolder{
    	private static final DiceFactory INSTANCE = new FairDiceFactory(getNumberGenerator());

		private static NumberBetweenUpperAndLowerBoundGenerator getNumberGenerator(){
			NumberBetweenUpperAndLowerBoundGenerator numberBetweenUpperAndLowerBoundGenerator = null;
			try {
				numberBetweenUpperAndLowerBoundGenerator = new NumberBetweenUpperAndLowerBoundGenerator(0, 1);
			} catch (UpperBoundLessThanOrEqualToLowerBoundException e) {
				e.printStackTrace();
			}
			return numberBetweenUpperAndLowerBoundGenerator;
		}
    }
}
