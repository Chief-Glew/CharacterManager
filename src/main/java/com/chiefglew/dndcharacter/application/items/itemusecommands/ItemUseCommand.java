package com.chiefglew.dndcharacter.application.items.itemusecommands;

import java.util.List;

import com.chiefglew.dndcharacter.application.commands.Command;
import com.chiefglew.dndcharacter.application.commands.Targetable;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

public interface ItemUseCommand extends Command{
	
	void addTarget(Targetable target);
	void removeTarget(Targetable target);
	void addDamage(Dice dice);
	List<Dice> getDamage();
	void setDamage(List<Dice> dice);

}
