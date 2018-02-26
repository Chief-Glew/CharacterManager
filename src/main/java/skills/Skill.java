package skills;

import stats.Stat;

public abstract class Skill {

    private Stat rollModifier;

    protected Skill(Stat rollModifier) {
        this.rollModifier = rollModifier;
    }

    public Stat getRollModifier() {
        return rollModifier;
    }
}
