package pippin;

public class SUBN extends SUB {

	public SUBN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	/**
	 * use the data value stored at data memory location X as the location 
	 * of the data value to be subtracted from the contents of the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
