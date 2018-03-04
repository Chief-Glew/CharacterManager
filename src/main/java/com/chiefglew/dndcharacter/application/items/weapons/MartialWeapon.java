package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

import java.util.List;

public abstract class MartialWeapon extends Weapon {
    public MartialWeapon(List<Dice> damage) {
        super(damage);
    }
}
