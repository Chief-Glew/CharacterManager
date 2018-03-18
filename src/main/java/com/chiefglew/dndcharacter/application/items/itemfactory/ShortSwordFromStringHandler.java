package com.chiefglew.dndcharacter.application.items.itemfactory;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;
import com.chiefglew.dndcharacter.application.items.itemusecommands.MeleeAttackCommand;
import com.chiefglew.dndcharacter.application.items.weapons.ShortSword;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

@Component
public class ShortSwordFromStringHandler extends GetItemHandler {
	
	private Dice d6;

	@Autowired
	public ShortSwordFromStringHandler(@Qualifier("d6") Dice d6) {
		super("ShortSword");
		this.d6 = d6;
	}

	@Override
	protected Item handlerMethod() {
		ItemUseCommand useCommand = new MeleeAttackCommand(new LinkedList<Dice>());
		useCommand.addDamage(d6);
		return new ShortSword(useCommand);
	}

}
