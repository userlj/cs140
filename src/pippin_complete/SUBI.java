package pippin_complete;

public class SUBI extends Instruction
{
	public SUBI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Subtracts the argument from the accumulator
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setAccumulator(cpu.getAccumulator() - arg);
		cpu.incrementIP();
	}
	public boolean isImmediate() { 
		return true; 
	}
}