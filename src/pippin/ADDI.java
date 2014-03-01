package pippin;

public class ADDI extends Instruction {

	public ADDI(Processor cpu, Memory memory) {
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
	 *  add Z to the contents of the accumulator.  
	 */
	public void execute(int arg) throws DataAccessException {
		int acc = cpu.getAccumulator();
		int newvalue = arg + acc;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}
}
