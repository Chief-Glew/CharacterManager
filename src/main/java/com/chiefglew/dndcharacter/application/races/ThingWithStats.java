package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.stats.StatHolder;

import java.util.Set;

public interface ThingWithStats {

	int getModifier(Skill skill);

	StatHolder getStats();

    Set<Skill> getSkills();
}
