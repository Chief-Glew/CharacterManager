package com.chiefglew.dndcharacter.application.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SkillFactory {

    private Set<Skill> skills;

    @Autowired
    public SkillFactory(Set<Skill> skills){
        this.skills = skills;
    }

    protected Skill getSkill(Class<? extends Skill> skillClass) {
        Skill returnValue = null;
        for (Skill skill: skills){
            if (skill.getClass() == skillClass){
                returnValue = skill;
            }
        }
        return returnValue;
    }

    public Skill getPerception() {
        return getSkill(Perception.class);
    }

    public Skill getStrengthCheck() {
        return getSkill(StrengthCheck.class);
    }
}
