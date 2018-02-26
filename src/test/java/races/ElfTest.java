package races;

import org.junit.Before;
import org.junit.Test;
import skills.Perception;
import skills.SkillFactory;
import stats.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        Race skillFactory.getPerception());
        assertEquals(2, elf.getModifier(Perception.class));
    }
}
