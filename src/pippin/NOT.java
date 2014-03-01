package pippin;

public class NOT extends Instruction {

	public NOT(Processor cpu, Memory memory) {
		super(cpu, memory);
	}
	
	@Override
	/** 
	 * Indicate if this is instruction requires an argument
	 */ 
	public boolean requiresArgument() { 
		return false; 
	} 
	
	@Override
	/**
	 *  if the accumulator contains 0, put 1 into the accumulator; 
	 *  otherwise put 0 into the accumulator. 
	 */
	public void execute(int arg) throws DataAccessException {
		if (cpu.getAccumulator() == 0)
			cpu.setAccumulator(1);
		else 
			cpu.setAccumulator(0);
			
		cpu.incrementIP();
	}
}
