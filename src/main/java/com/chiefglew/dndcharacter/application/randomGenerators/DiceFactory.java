package com.chiefglew.dndcharacter.application.randomGenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiceFactory {

    private NumberGenerator numberGenerator;

    @Autowired
    public DiceFactory(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }

    public Dice getD6() {
        return new Dice(6, numberGenerator);
    }
}
