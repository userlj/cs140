package pippin_complete;

public class MULI extends Instruction
{
	public MULI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Multiplies the accumulator by arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setAccumulator(cpu.getAccumulator() * arg);
		cpu.incrementIP();
	}
	public boolean isImmediate() { 
		return true; 
	}
}