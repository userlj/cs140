package pippin;

public class JUMP extends Instruction {

	public JUMP(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  put X in the program counter, causing the instruction at location X to be the next instruction executed
	 */
	public void execute(int arg) throws DataAccessException {
		cpu.setInstructionPointer(arg);
	}
}
