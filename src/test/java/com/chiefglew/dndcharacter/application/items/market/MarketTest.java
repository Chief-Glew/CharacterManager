package com.chiefglew.dndcharacter.application.items.market;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.Valuable;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MarketTest {

	@Autowired
    private SellsGenericValuables<Item, Integer> emptyMarket;
    @Autowired
    private ItemFactory itemFactory;
    private GenericTrade<Item, Valuable> trade;
    private Item shortSword;
    private String itemKey = "ShortSword";
    @Autowired
    private CurrencyFactory currencyFactory;
    private Inventory<Valuable> valuables;
    
    @Before
    public void init() throws OutOfStockException {
        valuables = new DefaultInventory<Valuable>();
        valuables.addall(currencyFactory.getGoldPieces(10));
        shortSword = itemFactory.getItem("ShortSword");
		emptyMarket.addStock(shortSword, 10, valuables);
        trade = new ItemTrade(new DefaultInventory<Item>(););
        trade.addValuablesToSell(currencyFactory.getPlatinumPeices(10));
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfterOneIsBought() throws OutOfStockException {
        emptyMarket.buyItem("ShortSword", trade);
        Map<String, Integer> stock = emptyMarket.getAmountOfItemsInStock();

        assertEquals(Integer.valueOf(9),stock.get(itemKey));
    }
    
    @Test
    public void testThatAppraiseReturnsAMapWithGoldPieceTenWhenGivenShortSword(){
    	Map<String, Integer> cost = emptyMarket.appraise(shortSword);
    	Map<String, Integer> expectedCost  = new HashMap<String, Integer>();
    	expectedCost.put("GoldPeice", 10);
    	assertEquals(expectedCost, cost);
    }


}
