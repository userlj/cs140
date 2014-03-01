package pippin_complete;

 public class MUL extends Instruction{

	public MUL(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		
		cpu.setAccumulator(memory.getData(arg)*cpu.getAccumulator());
		cpu.incrementIP();
		
	}
	
 }