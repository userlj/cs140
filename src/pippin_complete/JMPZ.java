package pippin_complete;

public class JMPZ extends JUMP
{
	public JMPZ(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * If the accumulator is zero, set the IP to arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (cpu.getAccumulator() == 0)
			super.execute(arg);
		else
			cpu.incrementIP();
	}
}