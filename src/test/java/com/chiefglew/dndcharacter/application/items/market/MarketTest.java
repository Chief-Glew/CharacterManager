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
import com.chiefglew.dndcharacter.application.items.Valuable;
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
    private Map<Valuable, Integer> valuables;
    
    @Before
    public void init() throws OutOfStockException {
        valuables = new HashMap<>();
        valuables.putAll(currencyFactory.getGoldPieces(10));
        shortSword = itemFactory.getItem("ShortSword");
		emptyMarket.addStock(shortSword, 10, valuables);
        trade = new ItemTrade(new HashMap<>()); //TODO look up spring @Transactional
        trade.addValuablesToSell(currencyFactory.getGoldPieces(10));
    }

    @Test
    public void testThatThereAreNineShortSwordsLeftAfterOneIsBought() throws OutOfStockException {
        emptyMarket.buyItem("ShortSword", trade);
        Map<String, Integer> stock = emptyMarket.getAmountOfItemsInStock();

        assertEquals(Integer.valueOf(9),stock.get("ShortSword"));
    }
    
    @Test
    public void testThatAppraiseReturnsAMapWithGoldPieceTenWhenGivenShortSword() throws CouldNotHandleException{
    	Map<Valuable, Integer> cost = emptyMarket.appraise(shortSword);
    	Map<Valuable, Integer> expectedCost  = new HashMap<Valuable, Integer>();
    	expectedCost.putAll(currencyFactory.getGoldPieces(10));
    	assertEquals(expectedCost, cost);
    }
    
    @Test
    public void testThatTheMarketStockContainsTenGoldPiecesAfterAShortSwordIsBought() throws OutOfStockException{
    	emptyMarket.buyItem("ShortSword", trade);
    	Map<String, Integer> stock = emptyMarket.getAmountOfItemsInStock();
    	assertEquals(Integer.valueOf(10), stock.get("GoldPiece"));
    }
    
    @Test
    public void testThatTradeIsUnchangedWhenItDoesntContainTheRightTypeAndAmountOfThingsToSell() throws OutOfStockException{
    	
    	GenericTrade<Item, Item> trade = new ItemTrade(new HashMap<>());
        trade.addValuablesToSell(currencyFactory.getPlatinumPieces(10));
        GenericTrade<Item, Item> expectedTrade = new ItemTrade(new HashMap<>());
        expectedTrade.addValuablesToSell(currencyFactory.getPlatinumPieces(10));
        
        emptyMarket.buyItem("ShortSword", trade);
        
        assertEquals(expectedTrade, trade);
    }
    
    


}
