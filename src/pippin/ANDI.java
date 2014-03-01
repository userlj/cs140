package pippin;

public class ANDI extends Instruction {

	public ANDI(Processor cpu, Memory memory) {
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
	 *  if the contents of the accumulator and Z are both non-zero, 
	 *  put 1 into the accumulator; otherwise, put 0 into the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		if(cpu.getAccumulator() != 0 && arg != 0)
			cpu.setAccumulator(1);
		else
			cpu.setAccumulator(0);
		
		cpu.incrementIP();
	}
}
