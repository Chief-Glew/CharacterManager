package com.chiefglew.dndcharacter.application.stats;

public abstract class Stat {
    protected int value;
    protected int modifier;

    public Stat(int value) {
        this.value = value;
        updateModifier();
    }

    protected void updateModifier() {
        modifier = (value-10)/2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stat stat = (Stat) o;

        if (value != stat.value) return false;
        return modifier == stat.modifier;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + modifier;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stat{");
        sb.append("value=").append(value);
        sb.append(", modifier=").append(modifier);
        sb.append('}');
        return sb.toString();
    }

    public int getModifier() {
        return modifier;
    }

}
