package pippin;

public class NOP extends Instruction {

	public NOP(Processor cpu, Memory memory) {
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
	 * no operation, do nothing except increment the program counter
	 */
	public void execute(int arg) throws DataAccessException {
		cpu.incrementIP();
	}
}
