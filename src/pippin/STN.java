package pippin;

public class STN extends STO {

	public STN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * use the data value stored at data memory location X as the 
	 * location of where to store the contents of the accumulator. 
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
