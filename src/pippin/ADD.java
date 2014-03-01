package pippin;

public class ADD extends Instruction {

	public ADD(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  add the data value stored at data memory location X to the contents of the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		int value = memory.getData(arg);
		int acc = cpu.getAccumulator();
		int newvalue = value + acc;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}
}
