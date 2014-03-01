package pippin_complete;

public class JMZN extends JUMP
{
	public JMZN(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * If the accumulator is zero, set the IP to the value at the memory location indicated by arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		if (cpu.getAccumulator() == 0)
			super.execute(memory.getData(arg));
		else
			cpu.incrementIP();
	}
}