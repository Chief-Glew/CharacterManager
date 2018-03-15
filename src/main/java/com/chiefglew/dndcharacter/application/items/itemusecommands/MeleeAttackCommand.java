package com.chiefglew.dndcharacter.application.items.itemusecommands;

import java.util.List;

import com.chiefglew.dndcharacter.application.commands.Targetable;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

public class MeleeAttackCommand implements ItemUseCommand {

	private List<Dice> damage;
	
	

	public MeleeAttackCommand(List<Dice> damage) {
		this.damage = damage;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTarget(Targetable target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTarget(Targetable target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDamage(Dice dice) {
		damage.add(dice);
	}

	@Override
	public List<Dice> getDamage() {
		return damage;
	}

	@Override
	public void setDamage(List<Dice> dice) {
		this.damage = dice;
	}

}
