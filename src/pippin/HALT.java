package pippin;

public class HALT extends Instruction {
	boolean running = false;
	public HALT(Processor cpu, Memory memory) {
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
	 * halt program execution; don't do anything more--later a "running" boolean will be set to false
	 */
	public void execute(int arg) throws DataAccessException {
		running = false;
	}
}
