package pippin;

public class JMPZ extends Instruction {

	public JMPZ(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  if the accumulator contains 0, put X in the program counter, 
	 *  causing the instruction at location X to be the next instruction executed; 
	 *  otherwise increment the program counter
	 */
	public void execute(int arg) throws DataAccessException {
		if (cpu.getAccumulator() == 0)
			cpu.setInstructionPointer(arg);
		else
			cpu.incrementIP();
	}
}
