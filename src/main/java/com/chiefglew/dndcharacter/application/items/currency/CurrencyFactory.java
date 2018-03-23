package com.chiefglew.dndcharacter.application.items.currency;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CurrencyFactory {

	public Map<Currency, Integer> getGoldPieces(int amount) {
		return getCurrencyMap(new GoldPiece(), amount);
	}

	public Map<Currency, Integer> getPlatinumPieces(int amount) {
		return getCurrencyMap(new PlatinumPiece(), amount);
	}

	private Map<Currency, Integer> getCurrencyMap(Currency currency, int amount){
		Map<Currency, Integer> returnMap = new HashMap<>();
		returnMap.put(currency, amount);
		return returnMap;
	}
}
