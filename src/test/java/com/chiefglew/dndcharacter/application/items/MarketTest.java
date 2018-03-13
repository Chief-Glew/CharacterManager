package com.chiefglew.dndcharacter.application.items;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.chiefglew.dndcharacter.application.items.currency.PlatinumPiece;
import com.chiefglew.dndcharacter.exceptions.OutOfStockException;

public class MarketTest {

	@Autowired
    private Market smallMarket;
	private Item shortSword;
	
	@Before
	public void init() throws OutOfStockException{
		 Trade trade = new Trade(new HashSet<Valuable>(), new ArrayList<Item>());
	        trade.addValuableToSell(new PlatinumPiece(10));

	        trade = smallMarket.buyShortSword(trade);
	        shortSword = trade.getItems().get(1);
	}
}
