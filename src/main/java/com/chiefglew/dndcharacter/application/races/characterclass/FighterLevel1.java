package com.chiefglew.dndcharacter.application.races.characterclass;

import com.chiefglew.dndcharacter.application.races.CharacterInterface;
import com.chiefglew.dndcharacter.application.races.Race;

public class FighterLevel1 extends Fighter{

    protected FighterLevel1(FighterLevel1Builder classBuilder) {
        super(1, classBuilder);
    }


    public static class FighterLevel1Builder extends FighterBuilder{
        protected Race.RaceBuilder raceBuilder;

        public FighterLevel1Builder(Race.RaceBuilder raceBuilder) {
            this.raceBuilder = raceBuilder;
        }

        @Override
        public CharacterInterface getCharacter() {
            this.containedRace = raceBuilder.getRace();
            return new FighterLevel1(this);
        }

        public Race.RaceBuilder getRaceBuilder() {
            return this.raceBuilder;
        }

        public void setRaceBuilder(Race.RaceBuilder raceBuilder) {
            this.raceBuilder = raceBuilder;
        }
    }
}
