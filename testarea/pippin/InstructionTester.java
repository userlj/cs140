package pippin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InstructionTester {
	Processor cpu = new Processor();
	Memory memory = new Memory();
	int[] dataCopy = new int[Memory.DATA_SIZE];
	int accInit;
	int ipInit;
	
	@Before
	public void setup() {
		for (int i = 0; i < Memory.DATA_SIZE; i++) {
			dataCopy[i] = -5*Memory.DATA_SIZE + 10*i;
			try {
				memory.setData(i, -5*Memory.DATA_SIZE + 10*i);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			// Initially the memory will contain a known spread
			// of different numbers: 
			// -2560, -2550, -2540, ..., 0, 10, 20, ..., 2550 
			// This allows us to check that the instructions do 
			// not corrupt memory unexpectedly.
			// 0 is at index 256
		}
		accInit = 0;
		ipInit = 0;
	}
	
	@Test
	public void testNOPbasics(){
		Instruction instr = new NOP(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertFalse("Argument not required", instr.requiresArgument());
		assertEquals("Name is NOP", "NOP", instr.toString());
	}
	
	@Test
	public void testLODbasics(){
		Instruction instr = new LOD(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is LOD", "LOD", instr.toString());
	}
	
	@Test
	public void testLDNbasics(){
		Instruction instr = new LDN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is LDN", "LDN", instr.toString());
	}

	@Test
	public void testLODIbasics(){
		Instruction instr = new LODI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is LODI", "LODI", instr.toString());
	}

	@Test
	public void testSTObasics(){
		Instruction instr = new STO(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is STO", "STO", instr.toString());
	}
	
	@Test
	public void testSTNbasics(){
		Instruction instr = new STN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is STN", "STN", instr.toString());
	}
	
	@Test
	public void testADDbasics(){
		Instruction instr = new ADD(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is ADD", "ADD", instr.toString());
	}
	
	@Test
	public void testADDNbasics(){
		Instruction instr = new ADDN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is ADDN", "ADDN", instr.toString());
	}
	
	@Test
	public void testADDIbasics(){
		Instruction instr = new ADDI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is ADDI", "ADDI", instr.toString());
	}
	
	@Test
	public void testSUBbasics(){
		Instruction instr = new SUB(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is SUB", "SUB", instr.toString());
	}
	
	@Test
	public void testSUBNbasics(){
		Instruction instr = new SUBN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is SUBN", "SUBN", instr.toString());
	}
	
	@Test
	public void testSUBIbasics(){
		Instruction instr = new SUBI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is SUBI", "SUBI", instr.toString());
	}
	
	@Test
	public void testMULbasics(){
		Instruction instr = new MUL(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is MUL", "MUL", instr.toString());
	}
	
	@Test
	public void testMULNbasics(){
		Instruction instr = new MULN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is MULN", "MULN", instr.toString());
	}
	
	@Test
	public void testMULIbasics(){
		Instruction instr = new MULI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is MULI", "MULI", instr.toString());
	}
	
	@Test
	public void testDIVbasics(){
		Instruction instr = new DIV(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is DIV", "DIV", instr.toString());
	}
	
	@Test
	public void testDIVNbasics(){
		Instruction instr = new DIVN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is DIVN", "DIVN", instr.toString());
	}
	
	@Test
	public void testDIVIbasics(){
		Instruction instr = new DIVI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is DIVI", "DIVI", instr.toString());
	}
	
	@Test
	public void testANDbasics(){
		Instruction instr = new AND(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is AND", "AND", instr.toString());
	}
	
	@Test
	public void testANDIbasics(){
		Instruction instr = new ANDI(cpu, memory);
		//Test intrinsic properties
		assertTrue("Is immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is ANDI", "ANDI", instr.toString());
	}
	
	@Test
	public void testNOTbasics(){
		Instruction instr = new NOT(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertFalse("Argument not required", instr.requiresArgument());
		assertEquals("Name is NOT", "NOT", instr.toString());
	}
	
	@Test
	public void testCMPZbasics(){
		Instruction instr = new CMPZ(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is CMPZ", "CMPZ", instr.toString());
	}
	
	@Test
	public void testCMPLbasics(){
		Instruction instr = new CMPL(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is CMPL", "CMPL", instr.toString());
	}
	
	@Test
	public void testJUMPbasics(){
		Instruction instr = new JUMP(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is JUMP", "JUMP", instr.toString());
	}

	@Test
	public void testJMPNbasics(){
		Instruction instr = new JMPN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is JMPN", "JMPN", instr.toString());
	}

	@Test
	public void testJMPZbasics(){
		Instruction instr = new JMPZ(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is JMPZ", "JMPZ", instr.toString());
	}

	@Test
	public void testJMZNbasics(){
		Instruction instr = new JMZN(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertTrue("Argument is required", instr.requiresArgument());
		assertEquals("Name is JMZN", "JMZN", instr.toString());
	}

	@Test
	public void testHALTbasics(){
		Instruction instr = new HALT(cpu, memory);
		//Test intrinsic properties
		assertFalse("Is not immediate", instr.isImmediate());
		assertFalse("Argument is not required", instr.requiresArgument());
		assertEquals("Name is HALT", "HALT", instr.toString());
	}
	
	@Test
	public void testNOP(){
		Instruction instr = new NOP(cpu, memory);
		//Test that execute impacts the machine appropriately
		try {
			instr.execute(0);
		} catch (Exception ex) {
			fail("Exception thrown: " + ex.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData());
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Test accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
	}

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testLDNnegArg(){
        Instruction instr = new LDN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -2560+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testLDNbigArg(){
        Instruction instr = new LDN(cpu, memory); 
        int arg = 320;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -2560+3200 > 512
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testLODnegArg(){
        Instruction instr = new LOD(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testLODbigArg(){
        Instruction instr = new LOD(cpu, memory); 
        int arg = Memory.DATA_SIZE+1;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// Test whether load is correct with indirect addressing
	public void testLDN(){
		Instruction instr = new LDN(cpu, memory);
		cpu.setAccumulator(27);
		int arg = 261; // operand address is -2560+2610=50  
		try {
			// should load -2560+500 into the accumulator
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData());
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Test accumulator modified
        assertEquals("Accumulator changed", -2560+500,
                cpu.getAccumulator());
	}

	@Test
	// Test whether load is correct with direct addressing
	public void testLOD(){
		Instruction instr = new LOD(cpu, memory);
		cpu.setAccumulator(27);
		int arg = 12;
		try {
			// should load -1280+120 into the accumulator
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData());
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Test accumulator modified
        assertEquals("Accumulator changed", -2560+120,
                cpu.getAccumulator());
	}

	@Test
	// Test that load immediate works correctly
	public void testLODI(){
		Instruction instr = new LODI(cpu, memory);
		cpu.setAccumulator(27);
		int arg = 256;
		try {
			instr.execute(arg);
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 256,
                cpu.getAccumulator());
	}

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testSTNnegArg(){
        Instruction instr = new STN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -1280+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage()); 
            assertNotNull(ex);
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testSTNbigArg(){
        Instruction instr = new STN(cpu, memory); 
        int arg = 160;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -1280+1600 > 256
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testSTOnegArg(){
        Instruction instr = new STO(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testSTObigArg(){
        Instruction instr = new STO(cpu, memory); 
        int arg = Memory.DATA_SIZE + 1;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// Test whether store is correct with indirect addressing
	public void testSTN(){
		Instruction instr = new STN(cpu, memory);
		int arg = 261; // affected address is -2560+2610=50
		cpu.setAccumulator(567);
		dataCopy[50] = 567;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData());
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Test accumulator unchanged
        assertEquals("Accumulator unchanged", 567,
                cpu.getAccumulator());
	}

	@Test
	// Test whether store is correct with direct addressing
	public void testSTOdirect(){
		Instruction instr = new STO(cpu, memory);
		int arg = 12;
		cpu.setAccumulator(567);
		dataCopy[12] = 567;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData());
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Test accumulator unchanged
        assertEquals("Accumulator unchanged", 567,
                cpu.getAccumulator());
	}

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testADDNnegArg(){
        Instruction instr = new ADDN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -2560+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testADDNbigArg(){
        Instruction instr = new ADDN(cpu, memory); 
        int arg = 356;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -2560+3560 > 512
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testADDnegArg(){
        Instruction instr = new ADD(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testADDbigArg(){
        Instruction instr = new ADD(cpu, memory); 
        int arg = Memory.DATA_SIZE + 1;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the add is done correctly, when
    // addressing is direct: execute(...);
    public void testADD(){
    	Instruction instr = new ADD(cpu, memory); 
        int arg = 12; // we know that memory value is -2560+120
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have added -2560+120 to accumulator
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200-2560+120,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the add is done correctly, when
    // addressing is indirect: execute(...);
    public void testADDN(){
		Instruction instr = new ADDN(cpu, memory); 
        int arg = 261; // we know that memory value is -2560+2610=50 
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have added -2560+500 to accumulator
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200-2560+500,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testSUBNnegArg(){
        Instruction instr = new SUBN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -2560+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testSUBNbigArg(){
        Instruction instr = new SUBN(cpu, memory); 
        int arg = 356;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -2560+3560 > 512
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testSUBnegArg(){
        Instruction instr = new SUB(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testSUBbigArg(){
        Instruction instr = new SUB(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the subtraction is done correctly, when
    // addressing is direct: execute(...);
    public void testSUB(){
        Instruction instr = new SUB(cpu, memory); 
        int arg = 12; // we know that memory value is -2560+120
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have subtracted -1280+120 from accumulator
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200+2560-120,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the subtraction is done correctly, when
    // addressing is indirect: execute(...);
    public void testSUBN(){
		Instruction instr = new SUBN(cpu, memory); 
        int arg = 261; // we know that memory value is -2560+2610=50 
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have subtraction -2560+500 from accumulator
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200+2560-500,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testMULNnegArg(){
        Instruction instr = new MULN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -2560+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testMULNbigArg(){
        Instruction instr = new MULN(cpu, memory); 
        int arg = 356;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -2560+3560 > 512
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testMULnegArg(){
        Instruction instr = new MUL(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testMULdirectBigArg(){
        Instruction instr = new MUL(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the multiplication is done correctly, when
    // addressing is direct: execute(...);
    public void testMUL(){
        Instruction instr = new MUL(cpu, memory); 
        int arg = 12; // we know that memory value is -1280+120
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have multiplied the accumulator by -1280+120
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200*(-2560+120),
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the multiplication is done correctly, when
    // addressing is indirect: execute(...);
    public void testMULN(){
		Instruction instr = new MULN(cpu, memory); 
        int arg = 261; // we know that memory value is -2560+2610=50 
    	cpu.setAccumulator(200);
        try { 
            instr.execute(arg); 
            // should have multiplied the accumulator by -2560+500
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 200*(-2560+500),
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is a negative index.
    public void testDIVNnegArg(){
        Instruction instr = new DIVN(cpu, memory); 
        int arg = 12;
        try { // this is how you test that an exception is thrown
        	// the value at index 12 is -2560+120
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the actual operand
	// address is larger than the array size.
    public void testDIVNbigArg(){
        Instruction instr = new DIVN(cpu, memory); 
        int arg = 356;
        try { // this is how you test that an exception is thrown
        	// will true to get value from index -2560+3560 > 512
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testDIVnegArg(){
        Instruction instr = new DIV(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testDIVbigArg(){
        Instruction instr = new DIV(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the division is done correctly, when
    // addressing is direct;
    public void testDIV(){
        Instruction instr = new DIV(cpu, memory); 
        int arg = 264; // we know that memory value is -2560+2640=80
    	cpu.setAccumulator(222);
        try { 
            instr.execute(arg); 
            // should have divided the accumulator by -2560+1360 = 80
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 222/(-2560+2640),
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the division by zero throws exception
    // when addressing is direct
    public void testDIVbyZero(){
        Instruction instr = new DIV(cpu, memory); 
        int arg = Memory.DATA_SIZE/2;
    	cpu.setAccumulator(222);
        try { 
            instr.execute(arg); 
            fail("Exception not thrown"); // we should not reach this line
        } catch (DivideByZeroException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", 222,
                cpu.getAccumulator());
    }

    @Test 
    // this test checks whether the division by zero throws exception
    // when addressing is indirect
    public void testDIVNbyZero() {
        Instruction instr = new DIVN(cpu, memory);
        dataCopy[0] = 0;
        int arg = 256; // we know that memory value is -2560+2560=0 
    	cpu.setAccumulator(222);
        try { 
            memory.setData(0, 0);
            instr.execute(arg); 
            fail("Exception not thrown"); // we should not reach this line
        } catch (DivideByZeroException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");     
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", 222,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the division is done correctly, when
    // addressing is indirect
    public void testDIVN(){
		Instruction instr = new DIVN(cpu, memory); 
        int arg = 281; // we know that memory value is -2560+2810=250 
    	cpu.setAccumulator(222);
        try { 
            instr.execute(arg); 
            // should have divided the accumulator by -2560+2500 = -60
        } catch (DataAccessException ex) {
            fail("DataAccessException should not occur");           
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getClass().getSimpleName());
        }
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 222/(-2560+2500),
                cpu.getAccumulator());
    }

	@Test
	// this test checks whether the immediate addition is done correctly
	public void testADDI(){
		Instruction instr = new ADDI(cpu, memory);
		int arg = 300;
    	cpu.setAccumulator(222);
		try {
            // should have added 300 to the accumulator 
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 522,
                cpu.getAccumulator());
	}

	@Test
	// this test checks whether the immediate addition is done correctly
	public void testSUBI(){
		Instruction instr = new SUBI(cpu, memory);
		int arg = 300;
    	cpu.setAccumulator(222);
		try {
            // should have subtracted 300 from the accumulator 
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 222-300,
                cpu.getAccumulator());
	}

	@Test
	// this test checks whether the immediate multiplication is done correctly
	public void testMULI(){
		Instruction instr = new MULI(cpu, memory);
		int arg = 300;
    	cpu.setAccumulator(222);
		try {
            // should have multiplied the accumulator by 300 
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 222*300,
                cpu.getAccumulator());
	}

	@Test
	// this test checks whether the immediate division is done correctly
	public void testDIVI(){
		Instruction instr = new DIVI(cpu, memory);
		int arg = 30;
    	cpu.setAccumulator(222);
		try {
            // should have divided the accumulator by 30 
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
        assertArrayEquals(dataCopy, memory.getData()); 
        assertEquals("Instruction pointer was incremented", ipInit + 1,
                cpu.getInstructionPointer());
        assertEquals("Accumulator was changed", 222/30,
                cpu.getAccumulator());
	}

    @Test 
    // this test checks whether the division by zero throws exception
    // when instruction is immediate
    public void testDIVIbyZero(){
        Instruction instr = new DIVI(cpu, memory); 
        int arg = 0;
    	cpu.setAccumulator(222);
        try { 
            instr.execute(arg); 
            fail("Exception not thrown"); // we should not reach this line
        } catch (DivideByZeroException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", 222,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testANDnegArg(){
        Instruction instr = new AND(cpu, memory); 
        int arg = -12;
        cpu.setAccumulator(1);
        accInit = 1;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testANDbigArg(){
        Instruction instr = new AND(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        cpu.setAccumulator(1);
        accInit = 1;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// Check that the AND of 2 true values is true 
	public void testANDtrueTrue(){
		Instruction instr = new AND(cpu, memory);
		int arg = 10;
		cpu.setAccumulator(-7);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 1
        assertEquals("Accumulator is 1", 1,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of 2 false values is false
	public void testANDfalseFalse(){
		Instruction instr = new AND(cpu, memory);
		int arg = Memory.DATA_SIZE/2;
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of false and true values is false 
	public void testANDfalseTrue(){
		Instruction instr = new AND(cpu, memory);
		int arg = Memory.DATA_SIZE/2;
		cpu.setAccumulator(-10);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of true and false values is false 
	public void testANDtrueFalse(){
		Instruction instr = new AND(cpu, memory);
		int arg = 130;
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of 2 true values is true 
	public void testANDItrueTrue(){
		Instruction instr = new ANDI(cpu, memory);
		int arg = 10;
		cpu.setAccumulator(-7);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 1
        assertEquals("Accumulator is 1", 1,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of 2 false values is false
	public void testANDIfalseFalse(){
		Instruction instr = new ANDI(cpu, memory);
		int arg = 0;
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of false and true values is false 
	public void testANDIfalseTrue(){
		Instruction instr = new ANDI(cpu, memory);
		int arg = 0;
		cpu.setAccumulator(-10);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the AND of true and false values is false 
	public void testANDItrueFalse(){
		Instruction instr = new ANDI(cpu, memory);
		int arg = 130;
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Verify that true is changed to false
	public void testNOTnonZero(){
		Instruction instr = new NOT(cpu,memory);
		cpu.setAccumulator(10);
		try {
			// arg should be ignored
			instr.execute(2);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}	

	@Test
	// Verify that false is changed to true
	public void testNOTzero(){
		Instruction instr = new NOT(cpu,memory);
		cpu.setAccumulator(0);
		try {
			// arg should be ignored
			instr.execute(0);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 1
        assertEquals("Accumulator is 1", 1,
                cpu.getAccumulator());
	}	

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testCMPZnegArg(){
        Instruction instr = new CMPZ(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testCMPZbigArg(){
        Instruction instr = new CMPZ(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// Check that the comparing to a zero value gives true 
	public void testCMPZzero(){
		Instruction instr = new CMPZ(cpu, memory);
		int arg = Memory.DATA_SIZE/2;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 1
        assertEquals("Accumulator is 1", 1,
                cpu.getAccumulator());
	}

	@Test
	// Check that the comparing to a zero value gives true 
	public void testCMPZnonzero(){
		Instruction instr = new CMPZ(cpu, memory);
		int arg = 130;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer unchanged", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is a negative index.
    public void testCMPLnegArg(){
        Instruction instr = new CMPL(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when direct addressing is used and the operand address 
	// is larger than the array size.
    public void testCMPLbigArg(){
        Instruction instr = new CMPL(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// Check that the comparing less than 0 gives true
	public void testCMPLless(){
		Instruction instr = new CMPL(cpu, memory);
		int arg = 100;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 1
        assertEquals("Accumulator is 1", 1,
                cpu.getAccumulator());
	}

	@Test
	// Check that the comparing equal to 0 gives false
	public void testCMPLzero(){
		Instruction instr = new CMPL(cpu, memory);
		int arg = Memory.DATA_SIZE/2;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test
	// Check that the comparing to positive gives false
	public void testCMPLpos(){
		Instruction instr = new CMPL(cpu, memory);
		int arg = 10 + Memory.DATA_SIZE/2;
		try {
			instr.execute(arg);
		} catch(DataAccessException ex){
			fail("Should not throw DataAccessException");			
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit + 1,
                cpu.getInstructionPointer());
        //Accumulator is 0
        assertEquals("Accumulator is 0", 0,
                cpu.getAccumulator());
	}

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the address is a negative index.
    public void testJMPNnegArg(){
        Instruction instr = new JMPN(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the address 
	// is larger than the array size.
    public void testJMPNbigArg(){
        Instruction instr = new JMPN(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// test the indirect jump works
	public void testJMPN(){
		Instruction instr = new JMPN(cpu,memory);
		int arg = 268; // value at this index is -2560+2680=120
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer changed", -2560+2680,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator is unchanged", accInit,
                cpu.getAccumulator());
	}


	@Test
	// test the direct jump works	
	public void testJUMP(){
		Instruction instr = new JUMP(cpu,memory);
		int arg = 140; 
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer changed", 140,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator is unchanged", accInit,
                cpu.getAccumulator());
	}


	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the address is a negative index.
    public void testJMZNnegArg(){
        Instruction instr = new JMZN(cpu, memory); 
        int arg = -12;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test 
    // this test checks whether the DataAccessException is thrown 
	// when indirect addressing is used and the address 
	// is larger than the array size.
    public void testJMZNbigArg(){
        Instruction instr = new JMZN(cpu, memory); 
        int arg = Memory.DATA_SIZE;
        try { // this is how you test that an exception is thrown
            instr.execute(arg);
            fail("Exception not thrown"); // we should not reach this line
        } catch (DataAccessException ex) {
            assertNotNull("An exception message is expected",
                    ex.getMessage());           
        } catch (Exception ex) {
            fail("Wrong exception thrown: " +
                    ex.getClass().getSimpleName());
        }
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter untouched
        assertEquals("Instruction pointer unchanged", ipInit,
                cpu.getInstructionPointer());
        //Test program accumulator untouched
        assertEquals("Accumulator unchanged", accInit,
                cpu.getAccumulator());
    }

	@Test
	// test the indirect jump works when accumulator is 0
	public void testJMZN(){
		Instruction instr = new JMZN(cpu,memory);
		int arg = 268; // value at this index is -2560+2680=120
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer changed", -2560+2680,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator is unchanged", accInit,
                cpu.getAccumulator());
	}


	@Test
	// test the direct jump works when accumulator is 0
	public void testJMPZ(){
		Instruction instr = new JMPZ(cpu,memory);
		int arg = 140; 
		cpu.setAccumulator(0);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer changed", 140,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator is unchanged", accInit,
                cpu.getAccumulator());
	}


	@Test
	// test the indirect jump does nothing when accumulator is not 0
	public void testJMZNnonzero(){
		Instruction instr = new JMZN(cpu,memory);
		int arg = 268; // value at this index is -2560+2680=120
		cpu.setAccumulator(10);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator was set to 10", 10,
                cpu.getAccumulator());
	}

	@Test
	// test the direct jump does nothing when accumulator is not 0
	public void testJMPZnonzero(){
		Instruction instr = new JMPZ(cpu,memory);
		int arg = 140; 
		cpu.setAccumulator(10);
		try {
			instr.execute(arg);
		} catch (Exception e) {
			fail("Should not throw any exceptions: " + 
					e.getClass().getSimpleName());
		}
		//Test memory is not changed
        assertArrayEquals(dataCopy, memory.getData()); 
        //Test program counter incremented
        assertEquals("Instruction pointer incremented", ipInit+1,
                cpu.getInstructionPointer());
        //Accumulator is unchanged
        assertEquals("Accumulator was set to 10", 10,
                cpu.getAccumulator());
	}

//// The test for HALT WILL COME, WHEN FLAG IS AVAILABLE IN THE Machine.
}
