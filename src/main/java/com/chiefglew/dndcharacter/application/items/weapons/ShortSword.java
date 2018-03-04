package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("prototype")
public class ShortSword extends MartialMeleeWeapon{

    @Autowired
    public ShortSword(Dice d6){
        super(Arrays.asList(d6));
    }
}
