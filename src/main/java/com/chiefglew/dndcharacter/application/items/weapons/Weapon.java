package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;

import java.util.List;

public interface Weapon{
    List<Dice> getDamage();
}
