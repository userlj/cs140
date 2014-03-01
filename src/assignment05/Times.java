package assignment05;

/**
 * Times arg by value.
 * @author lmeng4
 */
public class Times extends Operator{

	/**
	 * Constructs from superclass and passes the value to 
	 * the constructor of Operator.
	 * @param arg argument passed from class Operator
	 */
	public Times(double arg) {
		super(arg);
	}

	/**
	 *  Times arg by value.
	 *  @return result
	 */
	@Override
	public double modify(double value) {
		return value*getArg();
	}

}
