package pippin_complete;

public class AND extends Instruction
{
	public AND(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * If accumulator is 0, make it 1. Otherwise, make it 0
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (cpu.getAccumulator() != 0 && memory.getData(arg) != 0)
			cpu.setAccumulator(1);
		else
			cpu.setAccumulator(0);
		cpu.incrementIP();
	}
}