package com.chiefglew.dndcharacter.application.items.weapons;

import com.chiefglew.dndcharacter.application.randomGenerators.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImprovisedWeapon implements Weapon {


    private List<Dice> damage;

    @Autowired
    public ImprovisedWeapon(Dice d4) {
        damage = new ArrayList<Dice>();
        damage.add(d4);
    }


    @Override
    public List<Dice> getDamage() {
        return damage;
    }
}
