package com.chiefglew.skills;

import stats.Stat;

public abstract class Skill {

    private Class<? extends Stat> rollModifier;

    protected Skill(Class<? extends Stat> rollModifier) {
        this.rollModifier = rollModifier;
    }

    public Class<? extends Stat> getRollModifier() {
        return rollModifier;
    }
}
