package com.chiefglew.dndcharacter.application.randomGenerators;

public interface DiceFactory {
	
	Dice getDiceWithNumberOfSides(int NumberOfSides);

	Dice getD2();

	Dice getD4();
	
	Dice getD6();
	
	Dice getD8();
	
	Dice getD10();
	
	Dice getD20();
}
