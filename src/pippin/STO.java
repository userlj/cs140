package pippin;

public class STO extends Instruction {

	public STO(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * store the contents of the accumulator in data memory location arg.
	 */
	public void execute(int arg) throws DataAccessException {
		int value = cpu.getAccumulator();
		memory.setData(arg, value);
		cpu.incrementIP();
	}
}
