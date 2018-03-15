package com.chiefglew.dndcharacter.application.items.weapons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.application.items.itemusecommands.ItemUseCommand;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.DiceFactory;
import com.chiefglew.dndcharacter.config.AppConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ShortSwordTest {

	@Autowired
	private DiceFactory diceFactory;
	@Autowired
	private ItemFactory itemFactory;

	private Item shortSword;

	@Before
	public void init() {
		List<Dice> damage = new ArrayList<>();
		damage.add(diceFactory.getD6());
		shortSword = itemFactory.getItem("shortSword");
	}

	@Test
	public void testThatGetDamageReturnsAListOfDiceThatContainsAd6() {
		List<Dice> damage = new ArrayList<Dice>();
		ItemUseCommand attackCommmand = shortSword.useItem();
		damage.add(diceFactory.getD6());
		assertEquals(damage, attackCommmand.getDamage());
	}

}
