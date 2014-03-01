package pippin_complete;

public class JUMP extends Instruction
{
	public JUMP(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Sets the IP to arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setInstructionPointer(arg);
	}
}