package com.chiefglew.dndcharacter.application.races;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Elf extends Race {

    protected Elf(RaceBuilder elfBuilder) {
        super(elfBuilder);
    }

    @Component
    @Scope("prototype")
    public static class ElfBuilder extends Race.RaceBuilder{

        public ElfBuilder(StatFactory statFactory) {
            super(statFactory);
        }

        @Override
        public RaceBuilder setDexterity(int value){
            super.setDexterity(value+2);
            return this;
        }

        @Override
        public Race getRace() {
            return new Elf(this);
        }
    }
}