package com.chiefglew.dndcharacter.application.races;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.chiefglew.dndcharacter.application.stats.Stat;

@Configurable
public class StatFactory {
	
	@Autowired
	private List<Stat> stats;

	public Stat getStatByName(String statName){
		for (Stat stat : stats) {
			if(true){
				return stat;
			}
		}
		return null;
	}
	
	public Stat getStrength() {
		// TODO Auto-generated method stub
		return null;
	}

}
