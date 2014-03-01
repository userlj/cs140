package pippin_complete;

public class ADDI extends Instruction
{

	public ADDI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	public boolean isImmediate() { 
		return true; 
	}

	/**
	 * Adds the argument to the accumulator
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setAccumulator(cpu.getAccumulator() + arg);
		cpu.incrementIP();
	}
}
