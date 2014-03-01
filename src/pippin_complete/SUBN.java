package pippin_complete;

public class SUBN extends SUB {

	public SUBN(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
		
	}
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		super.execute(memory.getData(arg));
	}
}
