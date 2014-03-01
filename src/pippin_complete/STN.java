package pippin_complete;

public class STN extends STO
{
	public STN(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Load the accumulator with the value at memory location indicated by the value at arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		super.execute(memory.getData(arg));
	}
}