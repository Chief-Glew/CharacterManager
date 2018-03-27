package com.chiefglew.dndcharacter.application.races;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class RaceFactory {

    @Autowired
    private StatFactory statFactory;

    public Race getElf(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        Race.RaceBuilder elfBuilder = new Elf.ElfBuilder(statFactory);
        elfBuilder
                .setStrength(strength)
                .setDexterity(dexterity)
                .setConstitution(constitution)
                .setIntelligence(intelligence)
                .setWisdom(wisdom)
                .setCharisma(charisma)
                .setProficiencyModifier(2);
        return elfBuilder.getRace();
    }
}
