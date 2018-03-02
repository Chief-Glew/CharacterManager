package com.chiefglew.dndcharacter.application.randomGenerators;

public class UpperBoundLessThanOrEqualToLowerBoundException extends Throwable {
    private final double lowerBound;
    private final double upperBound;

    public UpperBoundLessThanOrEqualToLowerBoundException(double lowerBound, double upperBound) {
        super(upperBound + " is greater than " + lowerBound);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }
}
