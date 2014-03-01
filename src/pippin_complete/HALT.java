package pippin_complete;

public class HALT extends Instruction
{
	public HALT(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	@Override
	public boolean requiresArgument() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Halts the program
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		// Do nothing for now, eventually set Running to false
	}
}