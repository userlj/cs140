package pippin;

import java.util.HashMap;
import java.util.Map;

public class Tester {
    static Processor cpu = new Processor();
    static Memory memory = new Memory();
    
    public static Map<Integer, Instruction> decoder = new HashMap<Integer, Instruction>();
    static {
        decoder.put(0, new NOP(cpu, memory)); 
        decoder.put(1, new LOD(cpu, memory)); 
        decoder.put(2, new LODI(cpu, memory)); 
        decoder.put(3, new STO(cpu, memory)); 
        decoder.put(4, new ADD(cpu, memory)); 
        decoder.put(5, new SUB(cpu, memory)); 
        decoder.put(6, new MUL(cpu, memory)); 
        decoder.put(7, new DIV(cpu, memory)); 
        decoder.put(8, new ADDI(cpu, memory)); 
        decoder.put(9, new SUBI(cpu, memory)); 
        decoder.put(0x10, new AND(cpu, memory)); // 
        decoder.put(0x11, new ANDI(cpu, memory)); // 
        decoder.put(0x0A, new MULI(cpu, memory)); 
        decoder.put(0x0B, new DIVI(cpu, memory)); 
        decoder.put(0x12, new NOT(cpu, memory)); 
        decoder.put(0x13, new CMPZ(cpu, memory)); 
        decoder.put(0x14, new CMPL(cpu, memory)); 
        decoder.put(101, new LDN(cpu, memory)); 
        decoder.put(103, new STN(cpu, memory)); 
        decoder.put(104, new ADDN(cpu, memory)); 
        decoder.put(105, new SUBN(cpu, memory)); 
        decoder.put(106, new MULN(cpu, memory)); 
        decoder.put(107, new DIVN(cpu, memory)); 
        decoder.put(0x1A, new JUMP(cpu, memory)); 
        decoder.put(0x11A, new JMPN(cpu, memory)); 
        decoder.put(0x1B, new JMPZ(cpu, memory)); 
        decoder.put(0x11B, new JMZN(cpu, memory)); 
        decoder.put(0x1F, new HALT(cpu, memory)); 

    }
	/**
	 * @param args
	 * @throws DataAccessException 
	 * @throws CodeAccessException 
	 */
	public static void main(String[] args) throws DataAccessException, CodeAccessException {
		// TODO Auto-generated method stub
		for(int i = 0; i < 512; i++) {
			memory.setData(i, 5*i);
		}
		for(int i = 0; i < 4; i++) {
			memory.setCode(i, (((long)4+i) << 32) + i + 20);
		}
		for(int i = 4; i < 8; i++) {
			memory.setCode(i, (((long)100+i) << 32) + i + 20);
		}
		memory.setCode(8, (((long)0) << 32) + 0);//NOP, no param
		memory.setCode(9, (((long)1) << 32) + 11);//LOD
		memory.setCode(10, (((long)2) << 32) + 5);//LODI
		memory.setCode(11, (((long)3) << 32) + 11);//STO
		memory.setCode(12, (((long)101) << 32) + 3);//LDN value = 3*5*5 = 75
		memory.setCode(13, (((long)103) << 32) + 4);//STN memory location 4*5=20 ,System.out.println(memory.getData(20));
		memory.setCode(14, (((long)8) << 32) + 1);//ADDI
		memory.setCode(15, (((long)9) << 32) + 2);//SUBI
		memory.setCode(16, (((long)0x0A) << 32) + 3);//MULI
		memory.setCode(17, (((long)0x0B) << 32) + 4);//DIVI
		memory.setCode(18, (((long)0x10) << 32) + 1);//AND
		memory.setCode(19, (((long)0x11) << 32) + 1);//ANDI
		memory.setCode(20, (((long)0x12) << 32) + 1);//NOT, no param
		memory.setCode(21, (((long)0x13) << 32) + 0);//CMPZ
		memory.setCode(22, (((long)0x14) << 32) + 0);//CMPL
//		memory.setCode(23, (((long)0x1A) << 32) + 23);//JUMP
//		memory.setCode(23, (((long)0x11A) << 32) + 2);//JMPN
//		memory.setCode(23, (((long)0x1B) << 32) + 9);//JMPZ
//		memory.setCode(23, (((long)0x11B) << 32) + 2);//JMZN
		memory.setCode(23, (((long)0x1F) << 32) + 2);//HALT no param
		
		System.out.println(cpu.getAccumulator());
		while(cpu.getInstructionPointer() < 23) {
			long instr = memory.getCode(cpu.getInstructionPointer());
			int op = (int)(instr >> 32); 
			int arg = (int) (instr - ((long)op << 32));
//			System.out.println("op: " + op + " " + "instr: " + instr);
			System.out.println(decoder.get(op).getClass().getSimpleName() + " " + arg);
			decoder.get(op).execute(arg);
			System.out.println(cpu.getAccumulator());
		}
	}
}
