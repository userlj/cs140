package assignment08;

public class ClubSandwich implements Eatable {
	private double cost = 12.0;
	private int calories = 510;
	public ClubSandwich() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	public boolean equals(Eatable A, Eatable B) {
		if (A.getClass() == B.getClass()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
