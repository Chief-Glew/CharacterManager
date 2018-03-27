package com.chiefglew.dndcharacter.application.skills;

import com.chiefglew.dndcharacter.application.stats.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Perception extends Skill {

    @Autowired
    public Perception(Stat wisdom) {
        super("Perception", wisdom);
    }
}
