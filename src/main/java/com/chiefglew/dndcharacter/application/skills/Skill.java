package com.chiefglew.dndcharacter.application.skills;

import com.chiefglew.dndcharacter.application.stats.Stat;

public abstract class Skill implements Comparable<Skill> {

    private final Stat rollModifier;
    private final String name;

    protected Skill(String name, Stat rollModifier) {
        this.rollModifier = rollModifier;
        this.name = name;
    }

    public Stat getRollModifier() {
        return rollModifier;
    }

    @Override
    public int compareTo(Skill skill){
        return this.name.compareTo(skill.name);
    }
}
