package pippin;

public class ADDN extends ADD {

	public ADDN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	/**
	 * use the data value stored at data memory location X as the location 
	 * of the data value to be added to the contents of the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
