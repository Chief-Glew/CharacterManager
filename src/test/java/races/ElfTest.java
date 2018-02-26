package races;

import org.junit.Before;
import org.junit.Test;
import skills.Perception;
import skills.SkillFactory;
import stats.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ElfTest {

    private Race elf;
    private SkillFactory skillFactory;

    @Before
    public void init(){
        RaceFactory raceFactory = new RaceFactory();
        elf = raceFactory.getElf(10,10,10,10,10,10);
    }

    @Test
    public void testThatGetStatsReturnsAListOfStatsObjectsThatHaveAccountedForTheRacialModifiersOfAnElf(){
        Set<Stat> stats = new HashSet<Stat>();
        stats.add(new Strength(10));
        stats.add(new Dexterity(12));
        stats.add(new Constitution(10));
        stats.add(new Intelligence(10));
        stats.add(new Wisdom(10));
        stats.add(new Charisma(10));
        assertEquals(stats, elf.getStats());
    }

    @Test
    public void testThatAnElfThatIsProficientInPerceptionHasAPlusTwoModifierOnPerceptionChecks(){
        Perception perception = new Perception();
        elf.addProficiency(perception);
        /*
        elf has a bunch of skill objects representing proficiencies
        when a roll is to be made an object of the required type is passed to the elf (in this case perception)
        (the elf can compare this to it's proficiencies, adding the proficiency modifier to it's return if it is proficient)
        the elf is proficient in perception so adds it's proficiency modifier (+2) to it's wis modifier (+0) returning 2
         */
        assertEquals(2, elf.getModifier(perception));
    }
}
