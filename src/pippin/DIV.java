package pippin;

public class DIV extends Instruction {

	public DIV(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * do integer division on the accumulator by dividing by the data value stored at data memory location X.
	 */
	public void execute(int arg) throws DataAccessException {
			int value = memory.getData(arg);
			int acc = cpu.getAccumulator();
			int newvalue = acc/value;
			cpu.setAccumulator(newvalue);
			cpu.incrementIP();
	}

}