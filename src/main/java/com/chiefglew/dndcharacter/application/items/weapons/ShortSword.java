package com.chiefglew.dndcharacter.application.items.weapons;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommmand;
import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

@Component
@Scope("prototype")
public class ShortSword extends Item implements MartialMeleeWeapon{

	private List<Dice> damage;
	private ItemUseCommmand useCommand;
    
	@Autowired
    public ShortSword(@Qualifier("d6") Dice d6){
		this.damage = Arrays.asList(d6);
    }

	@Override
	public List<Dice> getDamage() {
		return damage;
	}

	@Override
	public ItemUseCommmand useItem() {
		return this.useCommand;
	}

	@Override
	public int getNumberOfUses() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
