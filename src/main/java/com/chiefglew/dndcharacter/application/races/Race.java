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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public abstract class Race implements ThingWithStats{

    private StatHolder stats;
    private Set<Skill> skills;
    private int proficiencyModifier;

    
    protected Race(RaceBuilder builder){
    	this.proficiencyModifier = builder.proficiencyModifier;
    	this.stats = new StatHolder(builder.stats);
    	this.skills = builder.skills;
    }

    @Override
	public StatHolder getStats() {
        return stats;
    }

    public void addProficiency(Skill skill) {
        this.skills.add(skill);
    }

    @Override
	public int getModifier(Skill skill) {
        Stat statRoll = skill.getRollModifier();
        int value = stats.getValue(statRoll);
        int modifier = (value-10)/2;
        if (skills.contains(skill)){
            modifier += proficiencyModifier;
        }
        return modifier;
    }

    @Component
    @Scope("prototype")
    public static abstract class RaceBuilder{

    	private StatFactory statFactory;
    	private Set<Skill> skills;
    	private Map<Stat, Integer> stats;
    	private int proficiencyModifier;

    	@Autowired
		public RaceBuilder(StatFactory statFactory){
            this.statFactory = statFactory;
            this.stats = new HashMap<>();
    		this.skills = new HashSet<>();
    	}

    	public RaceBuilder setStrength(int value){
    		stats.put(statFactory.getStrength(), value);
    		return this; 
    	}
    	
    	public RaceBuilder setDexterity(int value){
    		stats.put(statFactory.getDexterity(), value);
    		return this; 
    	}
    	
    	public RaceBuilder setConstitution(int value){
    		stats.put(statFactory.getConstitution(), value);
    		return this; 
    	}
    	
    	public RaceBuilder setIntelligence(int value){
    		stats.put(statFactory.getIntelligence(), value);
    		return this; 
    	}
    	
    	public RaceBuilder setWisdom(int value){
    		stats.put(statFactory.getWisdom(), value);
    		return this; 
    	}
    	
    	public RaceBuilder setCharisma(int value){
    		stats.put(statFactory.getCharisma(), value);
    		return this; 
    	}

    	public RaceBuilder addProficiency(Skill skill){
		    this.skills.add(skill);
		    return this;
        }

        public RaceBuilder setProficiencyModifier(int value){
		    this.proficiencyModifier = value;
		    return this;
        }

    	public abstract Race getRace();
    }
}
