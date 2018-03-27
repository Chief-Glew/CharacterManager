package com.chiefglew.dndcharacter.application.stats;

public abstract class Stat implements Comparable<Stat>{
    private final String name;

    public Stat(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Stat stat){
        return this.name.compareTo(stat.name);
    }
}
