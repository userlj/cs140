package pippin;

public class SUB extends Instruction {

	public SUB(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 * subtract the data value stored at data memory location X from the contents of the accumulator. 
	 */
	public void execute(int arg) throws DataAccessException {
		int value = memory.getData(arg);
		int acc = cpu.getAccumulator();
		int newvalue = acc - value;
		cpu.setAccumulator(newvalue);
		cpu.incrementIP();
	}


}
