package pippin_complete;

public class LOD extends Instruction
{
	public LOD(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Load the accumulator with the value at memory location arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		cpu.setAccumulator(memory.getData(arg));
		cpu.incrementIP();
	}
}