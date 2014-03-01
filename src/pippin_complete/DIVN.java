package pippin_complete;

public class DIVN extends DIV {

	public DIVN(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
		
	}
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		super.execute(memory.getData(arg));
	}
}