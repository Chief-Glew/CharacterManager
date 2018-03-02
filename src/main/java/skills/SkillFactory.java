package skills;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class SkillFactory {

    @Autowired
    private Set<Skill> skills;

    public SkillFactory(Set<Skill> skills){
        this.skills = skills;
    }

    public Skill getPerception() {
        return getSkill(Perception.class);
    }

    private Skill getSkill(Class<? extends Skill> skillClass) {
        Skill returnValue = null;
        for (Skill skill: skills){
            if (skill.getClass() == skillClass){
                returnValue = skill;
            }
        }
        return returnValue;
    }

    public Skill getStrength() {
        return getSkill(StrengthCheck.class);
    }
}
