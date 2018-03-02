package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.application.skills.Skill;
import stats.*;

import java.util.HashSet;
import java.util.Set;

public class RaceFactory {
    public Race getElf(int str, int dex, int con, int intel, int wis, int cha) {
        Set<Stat> stats = new HashSet<Stat>();
        stats.add(new Strength(str));
        stats.add(new Dexterity(dex + 2));
        stats.add(new Constitution(con));
        stats.add(new Intelligence(intel));
        stats.add(new Wisdom(wis));
        stats.add(new Charisma(cha));
        return new Elf(stats, new HashSet<Skill>(), 2);
    }
}
