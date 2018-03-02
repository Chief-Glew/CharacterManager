package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.application.skills.Skill;
import stats.Stat;

import java.util.Set;

public class Elf extends Race {
    protected Elf(Set<Stat> stats, Set<Skill> skills, int proficiencyModifier) {
        super(stats, skills, proficiencyModifier);
    }
}
