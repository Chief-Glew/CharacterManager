package com.chiefglew.dndcharacter.application.races;

import java.util.Set;

import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.stats.Stat;

public interface ThingWithStats {

	int getModifier(Skill skill);

	Set<Stat> getStats();

}
