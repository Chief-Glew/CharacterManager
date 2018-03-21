package com.chiefglew.dndcharacter.application.items.market;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.application.items.currency.GoldPiece;
import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MarketTest {

    private SellsGenericValuables<Item, Integer> smallMarket;
    @Autowired
    private ItemFactory itemFactory;
    private GenericTrade<Item> trade;
    private Item shortSword;
    private String itemKey = "ShortSword";
    @Autowired
    private CurrencyFactory currencyFactory;
    
    @Before
    public void init() throws OutOfStockException {
        smallMarket = new Market(new DefaultItemStock(new HashMap<>(), new HashMap<>()), new DoNothingValueHandler());
        List<Valuable> cost = new ArrayList<>();
        cost.addAll( currencyFactory.getGoldPieces(10));
        shortSword = itemFactory.getItem("ShortSword");
		smallMarket.addStock(shortSword, 10, cost);
        trade = new Trade(new HashSet<Valuable>());
        trade.addValuableToSell(new PlatinumPiece(10));
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfterOneIsBought() throws OutOfStockException {
        smallMarket.buyItem("ShortSword", trade);
        Map<String, Integer> stock = smallMarket.getAmountOfItemsInStock();

        assertEquals(Integer.valueOf(9),stock.get(itemKey));
    }
    
    @Test
    public void testThatAppraiseReturnsAMapWithGoldPieceTenWhenGivenShortSword(){
    	Map<String, Integer> cost = smallMarket.appraise(shortSword);
    	Map<String, Integer> expectedCost  = new HashMap<String, Integer>();
    	expectedCost.put("GoldPeice", 10);
    	assertEquals(expectedCost, cost);
    }


}
