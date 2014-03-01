package pippin_complete;

public class ANDI extends Instruction
{
	public ANDI(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	public boolean isImmediate() { 
		return true; 
	}
	/**
	 * If accumulator is 0, make it 1. Otherwise, make it 0
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (cpu.getAccumulator() != 0 && arg != 0)
			cpu.setAccumulator(1);
		else
			cpu.setAccumulator(0);
		cpu.incrementIP();
	}
}