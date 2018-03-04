package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

import java.util.List;

public abstract class MartialMeleeWeapon extends MartialWeapon{
    public MartialMeleeWeapon(List<Dice> damage) {
        super(damage);
    }
}
