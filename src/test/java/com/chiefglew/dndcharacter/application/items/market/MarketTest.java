package com.chiefglew.dndcharacter.application.items.market;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chiefglew.dndcharacter.application.items.Item;
import com.chiefglew.dndcharacter.application.items.currency.CurrencyFactory;
import com.chiefglew.dndcharacter.application.items.itemfactory.ItemFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import com.chiefglew.dndcharacter.exceptions.CouldNotHandleException;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MarketTest {

	@Autowired
    private SellsGenericValuables<Item, Integer> emptyMarket;
    @Autowired
    private ItemFactory itemFactory;
    private GenericTrade<Item, Item> trade;
    private Item shortSword;
    @Autowired
    private CurrencyFactory currencyFactory;
    private Map<String, Integer> valuables;
    
    @Before
    public void init() throws OutOfStockException {
        valuables = new HashMap<>();
        valuables.put("GoldPiece", 10);
        shortSword = itemFactory.getItem("ShortSword");
		emptyMarket.addStock(shortSword, 10, valuables);
        trade = new ItemTrade(new HashMap<>());
        trade.addValuablesToSell(currencyFactory.getPlatinumPieces(10));
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfterOneIsBought() throws OutOfStockException {
        emptyMarket.buyItem("ShortSword", trade);
        Map<String, Integer> stock = emptyMarket.getAmountOfItemsInStock();

        assertEquals(Integer.valueOf(9),stock.get("ShortSword"));
    }
    
    @Test
    public void testThatAppraiseReturnsAMapWithGoldPieceTenWhenGivenShortSword() throws CouldNotHandleException{
    	Map<String, Integer> cost = emptyMarket.appraise(shortSword);
    	Map<String, Integer> expectedCost  = new HashMap<String, Integer>();
    	expectedCost.put("GoldPiece", 10);
    	assertEquals(expectedCost, cost);
    }
    
    


}
