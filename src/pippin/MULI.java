package pippin;

public class MULI extends Instruction {

	public MULI(Processor cpu, Memory memory) {
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
	 * (multiply immediate) multiply the contents of the accumulator by Z. 
	 * Increment the program counter.
	 */
	public void execute(int arg) throws DataAccessException {
		int acc = cpu.getAccumulator();
		int newvalue = acc * arg;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}

}