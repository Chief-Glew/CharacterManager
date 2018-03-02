package com.chiefglew.dndcharacter.application.randomGenerators;

public class SpecificNumberGenerator implements NumberGenerator {

    private double number;

    public SpecificNumberGenerator(double number) {
        this.number = number;
    }

    @Override
    public double getNumber() {
        return number;
    }
}
