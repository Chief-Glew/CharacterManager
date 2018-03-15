package com.chiefglew.dndcharacter.application.randomGenerators;

public class NumberBetweenUpperAndLowerBoundGenerator implements NumberGenerator {
    private final double lowerBound;
    private final double upperBound;

    public NumberBetweenUpperAndLowerBoundGenerator(double lowerBound, double upperBound) throws UpperBoundLessThanOrEqualToLowerBoundException {
        if (lowerBound>=upperBound){
            throw new UpperBoundLessThanOrEqualToLowerBoundException(lowerBound, upperBound);
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double getNumber() {
        double difference = upperBound - lowerBound;
        double randomNumber = Math.random();
        randomNumber*=difference;
        randomNumber+=lowerBound;
        return randomNumber;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lowerBound);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(upperBound);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		NumberBetweenUpperAndLowerBoundGenerator other = (NumberBetweenUpperAndLowerBoundGenerator) obj;
		if (Double.doubleToLongBits(lowerBound) != Double.doubleToLongBits(other.lowerBound))
			return false;
		if (Double.doubleToLongBits(upperBound) != Double.doubleToLongBits(other.upperBound))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NumberBetweenUpperAndLowerBoundGenerator [lowerBound=");
		builder.append(lowerBound);
		builder.append(", upperBound=");
		builder.append(upperBound);
		builder.append("]");
		return builder.toString();
	}
    
    
}
