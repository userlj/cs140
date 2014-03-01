package pippin_complete;

 public class ADD extends Instruction{

	public ADD(Processor cpu, Memory memory) {
		super(cpu, memory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		// TODO Auto-generated method stub\
		int val = memory.getData(arg);
		int accumVal = cpu.getAccumulator();
		cpu.setAccumulator(val + accumVal);
		cpu.incrementIP();
		
	}
	
 }
 
 /*You must implement the execute(arg) method. This method uses arg as the index 
  * in the call to memory.getData to fetch the value stored in memory at location arg. 
  * You get the value of the processor's accumulator, add the fetched data value and then 
  * set this new value in the processor's accumulator. Finally you call incrementIP in
  *  the processor.

The steps above are summarized as:
add the data value stored at data memory location X to the contents of the accumulator. 
 The ADDN instruction is a subclass of Instruction. This instruction will not appear in 
 the assemble language but is the indirect version of ADD, which will be described later.
  The opcode is 256+4 = 260.
Make ADDN a subclass of ADD. The execute method uses arg to get the address of the value 
to be added to the accumulator. Hence you just have to write:
super.execute(memory.getData(arg));*/