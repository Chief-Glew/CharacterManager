package com.chiefglew.dndcharacter.application.randomGenerators;

public class Dice {

    private int sides;
    private NumberGenerator numberGenerator;

    public Dice(int sides, NumberGenerator numberGenerator){
        this.sides=sides;
        this.numberGenerator = numberGenerator;
    }

    public int roll(){
        double number = numberGenerator.getNumber();
        number %= 1;
        number*=sides;
        number+=1;
        return (int)number;
    }

    public int getSides() {
        return sides;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberGenerator == null) ? 0 : numberGenerator.hashCode());
		result = prime * result + sides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		if (numberGenerator == null) {
			if (other.numberGenerator != null)
				return false;
		} else if (!numberGenerator.equals(other.numberGenerator))
			return false;
		if (sides != other.sides)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dice [sides=");
		builder.append(sides);
		builder.append(", numberGenerator=");
		builder.append(numberGenerator);
		builder.append("]");
		return builder.toString();
	}


    
}
