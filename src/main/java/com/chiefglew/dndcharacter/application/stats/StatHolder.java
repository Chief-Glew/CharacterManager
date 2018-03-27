package com.chiefglew.dndcharacter.application.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StatHolder {

	private final Map<Stat, Integer> stats;

	public StatHolder(Map<Stat, Integer> stats) {
		this.stats = stats;
	}
	
	public int getValue(Stat stat){
		return stats.get(stat);
	}
	
	public Map<Stat, Integer> getStats(){
		Map<Stat, Integer> returnStats = new HashMap<>();
		returnStats.putAll(stats);
		return returnStats;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatHolder that = (StatHolder) o;
        return Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stats);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StatHolder{");
        sb.append("stats=").append(stats);
        sb.append('}');
        return sb.toString();
    }
}
