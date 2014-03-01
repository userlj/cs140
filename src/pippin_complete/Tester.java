package pippin_complete;

import java.util.HashMap;
import java.util.Map;

	public class Tester {
		 static Processor cpu = new Processor();
		 static Memory memory = new Memory();
		   
		    public static Map<Integer, Instruction> decoder = 
		    		new HashMap<Integer, Instruction>();
		    
		    static {
		        decoder.put(4, new ADD(cpu, memory));
		        decoder.put(5, new SUB(cpu, memory));
		        decoder.put(6, new MUL(cpu, memory));
		        decoder.put(7, new DIV(cpu, memory));
		        decoder.put(260, new ADDN(cpu, memory));
		        decoder.put(261, new SUBN(cpu, memory));
		        decoder.put(262, new MULN(cpu, memory));
		        decoder.put(263, new DIVN(cpu, memory));
		    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Did not have time to finish this part.
		
		/*int i = 0;
		for(i=0; i<Array.getLength(data[])-1; i++);
			memory.setData(i, 5*1);*/
			
		}
		

	}
