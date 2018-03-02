package com.chiefglew.dndcharacter.application.randomGenerators;

public class NumberBetweenUpperAndLowerBoundGenerator implements NumberGenerator {
    private final double lowerBound;
    private final double upperBound;

    public NumberBetweenUpperAndLowerBoundGenerator(double lowerBound, double upperBound) throws UpperBoundLessThanOrEqualToLowerBoundException {
        if (lowerBound>=upperBound){
            throw new UpperBoundLessThanOrEqualToLowerBoundException(lowerBound, upperBound);
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double getNumber() {
        double difference = upperBound - lowerBound;
        double randomNumber = Math.random();
        randomNumber*=difference;
        randomNumber+=lowerBound;
        return randomNumber;
    }
}
