package assignment05;

/**
 * Plus arg and value.
 * @author lmeng4
 */
public class Plus extends Operator{
	
	/**
	 * Constructs from superclass and passes the value to 
	 * the constructor of Operator.
	 * @param arg argument passed from class Operator
	 */
	public Plus(double arg) {
		super(arg);
	}

	/**
	 * Plus arg and value.
	 * @return result
	 */
	@Override
	public double modify(double value) {
		return value + getArg();
	}
}
