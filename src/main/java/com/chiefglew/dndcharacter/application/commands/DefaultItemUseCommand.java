package com.chiefglew.dndcharacter.application.commands;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

@Component
public class DefaultItemUseCommand implements ItemUseCommand {

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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dice> getDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDamage(List<Dice> dice) {
		// TODO Auto-generated method stub

	}

}
