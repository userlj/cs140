package pippin_complete;

public class JMPN extends JUMP
{
	public JMPN(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Sets the IP to the value at memory location arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		super.execute(memory.getData(arg));
	}
}