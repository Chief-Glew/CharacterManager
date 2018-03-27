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
        Race.RaceBuilder elfBuilder = getElfBuilder();
        elfBuilder
                .setStrength(strength)
                .setDexterity(dexterity)
                .setConstitution(constitution)
                .setIntelligence(intelligence)
                .setWisdom(wisdom)
                .setCharisma(charisma);
        return elfBuilder.getRace();
    }

    public Race.RaceBuilder getElfBuilder() {
        Race.RaceBuilder elfBuilder = new Elf.ElfBuilder(statFactory);
        elfBuilder
                .setStrength(10)
                .setDexterity(10)
                .setConstitution(10)
                .setIntelligence(10)
                .setWisdom(10)
                .setCharisma(10)
                .setProficiencyModifier(2);
        return elfBuilder;
    }
}
