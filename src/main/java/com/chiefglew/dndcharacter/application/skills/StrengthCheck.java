package com.chiefglew.dndcharacter.application.skills;

import com.chiefglew.dndcharacter.application.stats.Stat;
import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.stats.Strength;

@Component
public class StrengthCheck extends Skill {
    public StrengthCheck(Stat strength) {
        super("Strength Check", strength);
    }
}
