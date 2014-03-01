package pippin;

public class AND extends Instruction {

	public AND(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  if the contents of the accumulator and the data value stored at data memory location X 
	 *  are both non-zero, put 1 into the accumulator; otherwise, put 0 into the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		if(cpu.getAccumulator() != 0 && memory.getData(arg) != 0)
			cpu.setAccumulator(1);
		else 
			cpu.setAccumulator(0);
			
		cpu.incrementIP();
	}
}
