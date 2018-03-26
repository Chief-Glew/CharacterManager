package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.stats.Stat;
import com.chiefglew.dndcharacter.application.stats.StatHolder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

public abstract class Race implements ThingWithStats{

    private Set<Stat> stats;
    private Set<Skill> skills;
    private int proficiencyModifier;

    public Race(Set<Stat> stats, Set<Skill> skills, int proficiencyModifier) {
        this.stats = stats;
        this.skills = skills;
        this.proficiencyModifier = proficiencyModifier;
    }
    
    private Race(RaceBuilder builder){
    	
    }

    @Override
	public Set<Stat> getStats() {
        return stats;
    }

    public void addProficiency(Skill skill) {
        this.skills.add(skill);
    }

    @Override
	public int getModifier(Skill skill) {
        Class<? extends Stat> statRoll = skill.getRollModifier();
        int modifier = 0;
        for (Stat stat : stats) {
            if (stat.getClass() == statRoll) {
                modifier = stat.getModifier();
            }
        }
        if (skills.contains(skill)){
            modifier += proficiencyModifier;
        }
        return modifier;
    }
    
    @Configurable
    public static abstract class RaceBuilder{
    	
    	@Autowired
    	private StatFactory statFactory;
    	
    	private Map<Stat, Integer> stats;

		public RaceBuilder(){
    		this.stats = new HashMap<Stat, Integer>();
    	}
    	
    	public RaceBuilder setStrength(int value){
    		stats.put(statFactory.getStrength(), value);
    		return this; 
    	}
    }
}
