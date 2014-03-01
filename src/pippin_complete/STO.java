package pippin_complete;

public class STO extends Instruction
{
	public STO(Processor cpu, Memory memory)
	{
		super(cpu, memory);
	}

	/**
	 * Load the accumulator with the value at memory location arg
	 */
	@Override
	public void execute(int arg) throws DataAccessException
	{
		memory.setData(arg, cpu.getAccumulator());
		cpu.incrementIP();
	}
}