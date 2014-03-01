package assignment05;

/**
 * Divide arg by value.
 * @author lmeng4
 */
public class Divide extends Operator{

	/**
	 * Constructs from superclass and passes the value to 
	 * the constructor of Operator.
	 * @param arg argument passed from class Operator
	 */
	public Divide(double arg) {
		super(arg);
	}

	/**
	 * Divide arg by value.
	 * @return result
	 */
	@Override
	public double modify(double value) {
		return value / getArg();
	}

}
