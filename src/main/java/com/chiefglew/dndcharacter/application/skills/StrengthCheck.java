package com.chiefglew.dndcharacter.application.skills;

import org.springframework.stereotype.Component;
import stats.Strength;

@Component
public class StrengthCheck extends Skill {
    public StrengthCheck() {
        super(Strength.class);
    }
}