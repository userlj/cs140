package pippin;

public class LODI extends Instruction {

	public LODI(Processor cpu, Memory memory) {
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
	 * put arg into the accumulator. Increment the program counter.
	 */
	public void execute(int arg) throws DataAccessException {
		int value = arg;
		cpu.setAccumulator(value);
		cpu.incrementIP();
	}
}
