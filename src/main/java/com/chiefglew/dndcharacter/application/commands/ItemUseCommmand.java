package com.chiefglew.dndcharacter.application.commands;

import java.util.List;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

public interface ItemUseCommmand extends Command{
	
	void addTarget(Targetable target);
	void removeTarget(Targetable target);
	void addDamage(Dice dice);
	List<Dice> getDamage();
	void setDamage(List<Dice> dice);

}
