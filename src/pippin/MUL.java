package pippin;

public class MUL extends Instruction {

	public MUL(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * multiply the contents of the accumulator by the data value stored at data memory location X. 
	 */
	public void execute(int arg) throws DataAccessException {
		int value = memory.getData(arg);
		int acc = cpu.getAccumulator();
		int newvalue = acc * value;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}

}