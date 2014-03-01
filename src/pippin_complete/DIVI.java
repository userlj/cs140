package pippin_complete;

public class DIVI extends Instruction
{
	public DIVI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	
	public boolean isImmediate() { 
		return true; 
	}

	/**
	 * Divides the accumulator by the arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if(arg==0){ 
			throw new DivideByZeroException("Argument is zero");
		}
		cpu.setAccumulator(cpu.getAccumulator() / arg);
		cpu.incrementIP();
	}
}