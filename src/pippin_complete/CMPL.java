package pippin_complete;

public class CMPL extends Instruction
{
	public CMPL(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * If memory location arg is less than 0, make it 1. Otherwise, make it 0
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (memory.getData(arg) < 0)
			cpu.setAccumulator(1);
		else
			cpu.setAccumulator(0);
		cpu.incrementIP();
	}
}