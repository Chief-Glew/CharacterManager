package races;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import skills.Perception;
import skills.Skill;
import skills.SkillFactory;
import skills.StrengthCheck;
import stats.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ElfTest {

    private Race elf;
    private SkillFactory skillFactory;

    @Before
    public void init(){
        RaceFactory raceFactory = new RaceFactory();
        elf = raceFactory.getElf(10,10,10,10,10,8);
        //ApplicationContext applicationContext = dont remember spring.....
        skillFactory = new SkillFactory(new HashSet<Skill>(Arrays.asList(new Perception(), new StrengthCheck())));
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
        Skill strengthCheck = skillFactory.getStrength();
        assertEquals(0,elf.getModifier(strengthCheck));
    }
}
