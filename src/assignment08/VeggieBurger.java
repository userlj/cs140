package assignment08;

public class VeggieBurger implements Eatable {
	private double cost = 1.99;
	private int calories = 160;
	public VeggieBurger() {
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
