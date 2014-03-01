package pippin;

public class SUBI extends Instruction {

	public SUBI(Processor cpu, Memory memory) {
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
	 * (subtract immediate) subtract Z from the contents of the accumulator. 
	 * Increment the program counter.
	 */
	public void execute(int arg) throws DataAccessException {
		int acc = cpu.getAccumulator();
		int newvalue = acc - arg;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}


}
