package pippin;

public class MULN extends MUL {

	public MULN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	/**
	 * use the data value stored at data memory location X as the location 
	 * of the data value that will multiply the contents of the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
