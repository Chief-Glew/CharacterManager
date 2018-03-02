package com.chiefglew.randomGenerators;

public class Dice {

    private int sides;

    public Dice(int sides){
        this.sides=sides;
    }

    public int roll(){
        double randomNumber = Math.random();
        randomNumber*=sides;
        randomNumber+=1;
        return (int)randomNumber;
    }

    public int getSides() {
        return sides;
    }
}
