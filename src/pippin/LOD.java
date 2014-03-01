package pippin;

public class LOD extends Instruction {

	public LOD(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * put the data value stored at data memory location X into the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		int value = memory.getData(arg);
		cpu.setAccumulator(value);
		cpu.incrementIP();
	}
}
