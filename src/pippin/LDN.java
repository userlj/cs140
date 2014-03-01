package pippin;

public class LDN extends LOD {

	public LDN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * use the data value stored at data memory location X as the location of the data 
	 * and load that data into the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
