package pippin;

public class JMPN extends JUMP {

	public JMPN(Processor cpu, Memory memory) {
		super(cpu, memory);
	}

	@Override
	/**
	 *  use the data value stored at data memory location X as the value to be copied to the program counter
	 */
	public void execute(int arg) throws DataAccessException {
		super.execute(memory.getData(arg));
	}
}
