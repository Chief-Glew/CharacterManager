package com.chiefglew.dndcharacter.application.races.characterclass;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.stats.StatHolder;

import java.util.HashSet;
import java.util.Set;

public abstract class Fighter implements CharacterInterface, Comparable<Fighter> {
    protected final CharacterInterface containedRace;
    protected final Set<Skill> skills;
    private final String className;
    private final int level;

    protected Fighter(int level, FighterBuilder classBuilder) {
        this.className = "Fighter";
        this.level = level;
        this.skills = classBuilder.skills;
        this.containedRace = classBuilder.getContainedRace();
    }

    @Override
    public Set<Skill> getSkills() {
        Set<Skill> skills = containedRace.getSkills();
        Set<Skill> combinedSkills = new HashSet<>();
        combinedSkills.addAll(skills);
        combinedSkills.addAll(this.skills);
        return combinedSkills;
    }

    @Override
    public int getModifier(Skill skill) {
        return containedRace.getModifier(skill);
    }

    @Override
    public StatHolder getStats() {
        return containedRace.getStats();
    }

    @Override
    public int compareTo(Fighter fighter) {
        return this.level-fighter.level;
    }

    protected abstract static class FighterBuilder{

        protected Set<Skill> skills;

        protected CharacterInterface containedRace;

        protected FighterBuilder() {
            this.skills = new HashSet<>();
        }

        public abstract CharacterInterface getCharacter();

        public FighterBuilder addProficiency(Skill skill) {
            this.skills.add(skill);
            return this;
        }


        public CharacterInterface getContainedRace() {
            return containedRace;
        }
    }
}
