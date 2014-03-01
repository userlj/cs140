package pippin;

public class DIVN extends DIV {

	public DIVN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * use the data value stored at data memory location X as the location 
	 * of the data value for integer division of the accumulator divided by the data value.
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
