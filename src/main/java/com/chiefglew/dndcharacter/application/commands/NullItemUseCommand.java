package com.chiefglew.dndcharacter.application.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

@Component
@Qualifier("null")
public class NullItemUseCommand implements ItemUseCommand {

	@Override
	public void execute() {}

	@Override
	public void addTarget(Targetable target) {}

	@Override
	public void removeTarget(Targetable target) {}

	@Override
	public void addDamage(Dice dice) {}

	@Override
	public List<Dice> getDamage() {
		return new ArrayList<Dice>();
	}

	@Override
	public void setDamage(List<Dice> dice) {}

}
