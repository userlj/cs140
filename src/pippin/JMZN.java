package pippin;

public class JMZN extends JUMP {

	public JMZN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  if the accumulator contains 0, use the data value stored at data memory location X 
	 *  as the location to be copied to the program counter; 
	 *  otherwise increment the program counter
	 */
	public void execute(int arg) throws DataAccessException {
		if (cpu.getAccumulator() == 0)
			super.execute(memory.getData(arg));
		else
			cpu.incrementIP();
	}
}
