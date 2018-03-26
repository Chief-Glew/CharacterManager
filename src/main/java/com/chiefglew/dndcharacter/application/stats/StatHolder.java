package com.chiefglew.dndcharacter.application.stats;

import java.util.HashMap;
import java.util.Map;

public class StatHolder {

	private Map<Stat, Integer> stats;
	
	public StatHolder(){
		this(new HashMap<>());
	}

	public StatHolder(HashMap<Stat, Integer> stats) {
		this.stats = stats;
	}
	
	public int getValue(Stat stat){
		return stats.get(stat);
	}
	
	public Map<Stat, Integer> getStats(){
		Map<Stat, Integer> returnStats = new HashMap<>();
		returnStats.putAll(stats);
		return returnStats;
	}
}
