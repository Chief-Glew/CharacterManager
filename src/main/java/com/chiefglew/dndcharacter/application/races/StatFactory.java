package com.chiefglew.dndcharacter.application.races;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.chiefglew.dndcharacter.application.stats.Stat;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class StatFactory {
	
	@Autowired
	private List<Stat> stats;

	public Stat getStatByName(String statName){
		for (Stat stat : stats) {
			if(statName.equals(stat.getName())){
				return stat;
			}
		}
		return null;
	}
	
	public Stat getStrength() {
		return getStatByName("Strength");
	}

	public Stat getDexterity() {
        return getStatByName("Dexterity");
    }

	public Stat getConstitution() {
        return getStatByName("Constitution");
	}

	public Stat getIntelligence() {
        return getStatByName("Intelligence");
	}

    public Stat getWisdom() {
        return getStatByName("Wisdom");
    }

    public Stat getCharisma() {
        return getStatByName("Charisma");
    }
}
