package pippin;

public class DIVI extends Instruction {

	public DIVI(Processor cpu, Memory memory) {
		super(cpu, memory);
	}
	
	/**
	 * Indicate if this is an immediate instruction.
	 */
	@Override
	public boolean isImmediate() { 
		return true; 
	}
	
	@Override
	/**
	 * do integer division on the accumulator by dividing by Z. 
	 * Increment the program counter.
	 */
	public void execute(int arg) throws DataAccessException {
			int acc = cpu.getAccumulator();
			int newvalue = acc/arg;
			cpu.setAccumulator(newvalue);
			cpu.incrementIP();
	}

}