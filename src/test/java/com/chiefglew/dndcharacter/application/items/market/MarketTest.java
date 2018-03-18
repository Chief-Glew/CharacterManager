package com.chiefglew.dndcharacter.application.items.market;

import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.application.items.currency.GoldPiece;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MarketTest {

    private Market smallMarket;
    @Autowired
    private ItemFactory itemFactory;
    private Trade trade;
    private String itemKey = "ShortSword";

    @Before
    public void init() throws OutOfStockException {
        smallMarket = new Market(new DefaultItemStock(new HashMap<>(), new HashMap<>()), new DoNothingValueHandler());
        List<Currency> cost = new ArrayList<>();
        cost.add(new GoldPiece(10));
        smallMarket.addStock(itemFactory.getItem("ShortSword"), 10, cost);
        trade = new Trade(new HashSet<Valuable>());
        trade.addValuableToSell(new PlatinumPiece(10));
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfterOneIsBought() throws OutOfStockException {
        smallMarket.buyItem("ShortSword", trade);
        Map<String, Integer> stock = smallMarket.getAmountOfItemsInStock();

        assertEquals(Integer.valueOf(9),stock.get(itemKey));
    }


}
