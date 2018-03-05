package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.application.skills.Skill;
import stats.Stat;

import java.util.Set;

public abstract class Race {

    private Set<Stat> stats;
    private Set<Skill> skills;
    private int proficiencyModifier;

    public Race(Set<Stat> stats, Set<Skill> skills, int proficiencyModifier) {
        this.stats = stats;
        this.skills = skills;
        this.proficiencyModifier = proficiencyModifier;
    }

    public Set<Stat> getStats() {
        return stats;
    }

    public void addProficiency(Skill skill) {
        this.skills.add(skill);
    }

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
}