package pippin_complete;

 public class SUB extends Instruction{

	public SUB(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		
		cpu.setAccumulator(cpu.getAccumulator()-memory.getData(arg));
		cpu.incrementIP();
		
	}
	
 }