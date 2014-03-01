package pippin;

public class CMPZ extends Instruction {

	public CMPZ(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  if the data value stored at data memory location X is 0, 
	 *  put 1 into the accumulator; otherwise put 0 into the accumulator.
	 */
	public void execute(int arg) throws DataAccessException {
		if (memory.getData(arg) == 0)
			cpu.setAccumulator(1);
		else 
			cpu.setAccumulator(0);
			
		cpu.incrementIP();
	}
}
