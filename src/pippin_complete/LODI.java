package pippin_complete;

public class LODI extends Instruction
{
	public LODI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	public boolean isImmediate() { 
		return true; 
	}
	/**
	 * Load the accumulator with arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setAccumulator(arg);
		cpu.incrementIP();
	}
}