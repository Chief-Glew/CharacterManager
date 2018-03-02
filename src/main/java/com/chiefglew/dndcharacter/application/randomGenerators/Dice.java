package com.chiefglew.dndcharacter.application.randomGenerators;

public class Dice {

    private int sides;
    private NumberGenerator numberGenerator;

    public Dice(int sides, NumberGenerator numberGenerator){
        this.sides=sides;
        this.numberGenerator = numberGenerator;
    }

    public int roll(){
        double number = numberGenerator.getNumber();
        number %= 1;
        number*=sides;
        number+=1;
        return (int)number;
    }

    public int getSides() {
        return sides;
    }
}
