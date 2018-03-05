package com.chiefglew.dndcharacter.application.skills;

import org.springframework.stereotype.Component;

import com.chiefglew.dndcharacter.application.stats.Wisdom;

@Component
public class Perception extends Skill {

    public Perception() {
        super(Wisdom.class);
    }
}
