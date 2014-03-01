package assignment05;

/**
 * Minus value from arg.
 * @author lmeng4
 */
public class Minus extends Operator{
	
	/**
	 * Constructs from superclass and passes the value to 
	 * the constructor of Operator.
	 * @param arg argument passed from class Operator
	 */
	public Minus(double arg) {
		super(arg);
	}

	/**
	 * Minus value from arg.
	 * @return result
	 */
	@Override
	public double modify(double value) {
		return value - getArg();
	}

}
