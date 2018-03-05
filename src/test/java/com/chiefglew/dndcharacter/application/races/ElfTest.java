package com.chiefglew.dndcharacter.application.races;

import com.chiefglew.dndcharacter.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.chiefglew.dndcharacter.application.skills.Skill;
import com.chiefglew.dndcharacter.application.skills.SkillFactory;
import com.chiefglew.dndcharacter.application.stats.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ElfTest {

    private Race elf;
    @Autowired
    private SkillFactory skillFactory;

    @Before
    public void init(){
        RaceFactory raceFactory = new RaceFactory();
        elf = raceFactory.getElf(10,10,10,10,10,8);
    }

    @Test
    public void testThatGetStatsReturnsAListOfStatsObjectsThatHaveAccountedForTheRacialModifiersOfAnElf(){
        Set<Stat> stats = new HashSet<Stat>();
        stats.add(new Strength(10));
        stats.add(new Dexterity(12));
        stats.add(new Constitution(10));
        stats.add(new Intelligence(10));
        stats.add(new Wisdom(10));
        stats.add(new Charisma(8));
        assertEquals(stats, elf.getStats());
    }

    @Test
    public void testThatAnElfThatIsProficientInPerceptionHasAPlusTwoModifierOnPerceptionChecks(){
        Skill perception = skillFactory.getPerception();
        elf.addProficiency(perception);
        assertEquals(2, elf.getModifier(perception));
    }

    @Test
    public void testThatAnElfThatIsNotProficientInStrengthChecksHasAPlusZeroModifierOnStrengthChecks(){
        Skill strengthCheck = skillFactory.getStrengthCheck();
        assertEquals(0,elf.getModifier(strengthCheck));
    }
}
