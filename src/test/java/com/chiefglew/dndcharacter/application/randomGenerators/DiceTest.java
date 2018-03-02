package com.chiefglew.dndcharacter.application.randomGenerators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testThatATwoSidedDiceOnlyReturnsAOneOrATwoWhenRolled() throws UpperBoundLessThanOrEqualToLowerBoundException {
        Dice twoSidedDice = new Dice(2, new NumberBetweenUpperAndLowerBoundGenerator(0,1));
        int result = twoSidedDice.roll();
        assertTrue((result==1)||(result==2));
    }

    @Test
    public void testThatAOneSidedDiceAlwaysReturnsOneWhenRolled() throws UpperBoundLessThanOrEqualToLowerBoundException {
        Dice oneSidedDice = new Dice(1, new NumberBetweenUpperAndLowerBoundGenerator(0,1));
        assertEquals(1,oneSidedDice.roll());
    }

    @Test
    public void testThatADiceWithANumberGeneratorOfAHalfGivesTheSameRollAsOneWithSixAndAHalf(){
        Dice always4Dice = new Dice(6, new SpecificNumberGenerator(0.5));
        Dice stillAlways4Dice = new Dice(6, new SpecificNumberGenerator(6.5));
        assertEquals(always4Dice.roll(), stillAlways4Dice.roll());
    }

    @Test
    public void testThatADiceWithANumberGeneratorOfZeroWillAlwaysReturnOne(){
        Dice always1Dice = new Dice(20, new SpecificNumberGenerator(0));
        assertEquals(1, always1Dice.roll());
    }
}
