package com.chiefglew.dndcharacter.application.items.weapons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chiefglew.dndcharacter.application.commands.ItemUseCommand;
import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Market;
import com.chiefglew.dndcharacter.application.items.Trade;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.DiceFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ShortSwordTest {

    @Autowired
    private Market smallMarket;
    @Autowired
    private DiceFactory diceFactory;

    private Item shortSword;

    @Before
    public void init() throws MissingCurrencyException, OutOfStockException {
        Trade trade = new Trade(new HashSet<Valuable>(), new ArrayList<Item>());
        trade.addValuableToSell(new PlatinumPiece(10));

        trade = smallMarket.buyShortSword(trade);
        shortSword = trade.getItems().get(1);
    }

    @Test
    public void testThatGetDamageReturnsAListOfDiceThatContainsAd6(){
        List<Dice> damage = new ArrayList<Dice>();
        ItemUseCommand attackCommmand = shortSword.useItem();
        damage.add(diceFactory.getD6());
        assertEquals(damage,attackCommmand.getDamage());
    }

}
