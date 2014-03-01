package pippin_complete;

public class NOP extends Instruction
{
	public NOP(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}
	@Override
	public boolean requiresArgument() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * No Operation:
	 * Just increments the PC
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.incrementIP();
	}
}