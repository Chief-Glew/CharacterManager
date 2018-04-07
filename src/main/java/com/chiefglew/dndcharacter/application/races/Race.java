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

public abstract class Race implements CharacterInterface{

    private final long id;
    private final String name;
    private StatHolder stats;
    private Set<Skill> skills;
    private int proficiencyModifier;

    
    protected Race(RaceBuilder builder){
    	this.proficiencyModifier = builder.proficiencyModifier;
    	this.stats = new StatHolder(builder.stats);
    	this.skills = builder.skills;
    	this.name = builder.name;
    	this.id = builder.id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
	public StatHolder getStats() {
        return stats;
    }

    @Override
    public Set<Skill> getSkills(){
        return this.skills;
    }

    public void addSkill(Skill skill) {
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

    public String getName() {
        return name;
    }

    @Component
    @Scope("prototype")
    public static abstract class RaceBuilder{

    	private StatFactory statFactory;
    	private Set<Skill> skills;
    	private Map<Stat, Integer> stats;
    	private int proficiencyModifier;
        private String name;
        private int id;

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

        public RaceBuilder setName(String name){
        	this.name = name;
        	return this;
		}

        public RaceBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }
}
