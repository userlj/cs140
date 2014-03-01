package pippin_complete;

 public class DIV extends Instruction{

	public DIV(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		if(memory.getData(arg)==0){ 
			throw new DivideByZeroException("Argument is zero");
		}
		cpu.setAccumulator(cpu.getAccumulator()/memory.getData(arg));
		cpu.incrementIP();
		
	}
	
 }
