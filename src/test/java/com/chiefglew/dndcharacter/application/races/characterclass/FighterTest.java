package com.chiefglew.dndcharacter.application.races.characterclass;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.application.races.Race;
import com.chiefglew.dndcharacter.application.races.RaceFactory;
import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.skills.SkillFactory;
import com.chiefglew.dndcharacter.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class FighterTest {

    @Autowired
    private RaceFactory raceFactory;
    @Autowired
    private SkillFactory skillFactory;
    private Race.RaceBuilder elfBuilder;

    @Before
    public void init(){
        elfBuilder = raceFactory.getElfBuilder();
        elfBuilder.setProficiencyModifier(2)
                .setCharisma(10)
                .setWisdom(10)
                .setConstitution(10)
                .setDexterity(10)
                .setStrength(10)
                .setIntelligence(10)
                .addProficiency(skillFactory.getPerception());
    }

    @Test
    public void testThatGetProficienciesReturnsASetOfSkillsThatContainsTheProficienciesOfBothTheFighterAndTheElf(){
        Set<Skill> skills = new HashSet<>();
        skills.add(skillFactory.getPerception());
        skills.add(skillFactory.getStrengthCheck());

        FighterLevel1.FighterLevel1Builder fighterLevel1Builder = new FighterLevel1.FighterLevel1Builder(elfBuilder);
        fighterLevel1Builder.addProficiency(skillFactory.getStrengthCheck());
        CharacterInterface fighter = fighterLevel1Builder.getCharacter();
        assertEquals(skills, fighter.getSkills());
    }
}
