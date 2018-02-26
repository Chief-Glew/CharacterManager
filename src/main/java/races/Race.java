package races;

import stats.Stat;

import java.util.Set;

public abstract class Race {

    private Set<Stat> stats;

    public Race(Set<Stat> stats) {
        this.stats = stats;
    }

    public Set<Stat> getStats() {
        return stats;
    }
}
