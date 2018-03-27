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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ElfTest {

    private Race elf;
    @Autowired
    private SkillFactory skillFactory;
    @Autowired
    private StatFactory statFactory;
    @Autowired
    private RaceFactory raceFactory;

    @Before
    public void init(){
        elf = raceFactory.getElf(10,10,10,10,10,8);
        
    }

    @Test
    public void testThatGetStatsReturnsAStatHolderThatHasValuesWhichHaveAccountedForTheRacialModifiersOfAnElf(){
        Map<Stat, Integer> stats = new HashMap<>();
        stats.put(statFactory.getStrength(),10);
        stats.put(statFactory.getDexterity(),12);
        stats.put(statFactory.getConstitution(),10);
        stats.put(statFactory.getIntelligence(),10);
        stats.put(statFactory.getWisdom(),10);
        stats.put(statFactory.getCharisma(),8);
        StatHolder statHolder = new StatHolder(stats);
        assertEquals(statHolder, elf.getStats());
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
