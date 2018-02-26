package randomGenerators;

import org.junit.Test;
import randomGenerators.Dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testThatATwoSidedDiceOnlyReturnsAOneOrATwoWhenRolled(){
        Dice twoSidedDice = new Dice(2);
        int result = twoSidedDice.roll();
        assertTrue((result==1)||(result==2));
    }

    @Test
    public void testThatAOneSidedDiceAlwaysReturnsOneWhenRolled(){
        Dice oneSidedDice = new Dice(1);
        assertEquals(1,oneSidedDice.roll());
    }
}
