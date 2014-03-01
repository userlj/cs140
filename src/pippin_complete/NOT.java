package pippin_complete;

public class NOT extends Instruction
{
	public NOT(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	@Override
	public boolean requiresArgument() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * If accumulator is 0, make it 1. Otherwise, make it 0
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (cpu.getAccumulator() == 0)
			cpu.setAccumulator(1);
		else
			cpu.setAccumulator(0);
		cpu.incrementIP();
	}
}