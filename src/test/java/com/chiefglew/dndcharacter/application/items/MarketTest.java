package com.chiefglew.dndcharacter.application.items;

import com.chiefglew.dndcharacter.application.items.currency.Currency;
import com.chiefglew.dndcharacter.application.items.currency.GoldPiece;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.application.items.market.DefaultItemStock;
import com.chiefglew.dndcharacter.application.items.market.Market;
import com.chiefglew.dndcharacter.application.items.market.Trade;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MarketTest {

    private Market smallMarket;
    @Autowired
    private ItemFactory itemFactory;
    private Trade trade;

    @Before
    public void init() throws OutOfStockException {
        smallMarket = new Market(new DefaultItemStock(new HashMap<>(), new HashMap<>()), new NullValueHandler());
        List<Currency> cost = new ArrayList<>();
        cost.add(new GoldPiece(10));
        smallMarket.addStock(itemFactory.getItem("ShortSword"), 10, cost);
        trade = new Trade(new HashSet<Valuable>());
        trade.addValuableToSell(new PlatinumPiece(10));
        trade = smallMarket.buyItem("ShortSword", trade);
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfter


}
