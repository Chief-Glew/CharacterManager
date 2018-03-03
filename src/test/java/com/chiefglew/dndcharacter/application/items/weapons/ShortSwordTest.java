package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Market;
import com.chiefglew.dndcharacter.application.items.Wallet;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import com.chiefglew.dndcharacter.application.randomGenerators.DiceFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ShortSwordTest {

    @Autowired
    private Market smallMarket;
    @Autowired
    private DiceFactory diceFactory;
    @Autowired
    private Wallet wallet;
    private Item shortSword;

    @Before
    public void init() throws MissingCurrencyException {
        wallet.addFunds(new PlatinumPiece(10));
        shortSword = market.buyShortSword(wallet);
    }

    @Test
    public void testThatGetDamageReturnsAListOfDiceThatContainsAd6(){
        Weapon shortSwordWeapon = new WeaponWrapper(shortSword);
        List<Dice> damage = new ArrayList<Dice>();
        damage.add(diceFactory.getD6());
        assertEquals(damage,shortSwordWeapon.getDamage());
    }

}
