package pippin_complete;

public class LDN extends LOD
{
	public LDN(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Load the accumulator with the value at memory location indicated by the location at arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		super.execute(memory.getData(arg));
	}
}