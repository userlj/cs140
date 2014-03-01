package pippin_complete;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Assembler
{//1
	public static Map<String, Integer> opcodes = new HashMap<String, Integer>();
	public static Map<String, Boolean> requiresArgument = new HashMap<String, Boolean>();
	public static Map<String, String> indirectCode = new HashMap<String, String>();

	static {//2
		opcodes.put("LOD", 1);
		requiresArgument.put("LOD", true);

		opcodes.put("LDN", 256+1);
		requiresArgument.put("LDN", true);

		indirectCode.put("LOD", "LDN");

		opcodes.put("LODI", 2);
		requiresArgument.put("LODI", true);

		opcodes.put("STO", 3);
		requiresArgument.put("STO", true);

		opcodes.put("STN", 256+3);
		requiresArgument.put("STN", true);

		indirectCode.put("STO", "STN");

		opcodes.put("ADD", 4);
		requiresArgument.put("ADD", true);

		opcodes.put("ADDN", 256+4);
		requiresArgument.put("ADDN", true);

		indirectCode.put("ADD", "ADDN");

		opcodes.put("ADDI", 8);
		requiresArgument.put("ADDI", true);

		opcodes.put("SUB", 5);
		requiresArgument.put("SUB", true);

		opcodes.put("SUBN", 256+5);
		requiresArgument.put("SUBN", true);

		indirectCode.put("SUB", "SUBN");

		opcodes.put("SUBI", 9);
		requiresArgument.put("SUBI", true);

		opcodes.put("MUL", 6);
		requiresArgument.put("MUL", true);

		opcodes.put("MULN", 256+6);
		requiresArgument.put("MULN", true);

		indirectCode.put("MUL", "MULN");

		opcodes.put("MULI", 10);
		requiresArgument.put("MULI", true);

		opcodes.put("DIV", 7);
		requiresArgument.put("DIV", true);

		opcodes.put("DIVN", 256+7);
		requiresArgument.put("DIVN", true);

		indirectCode.put("DIV", "DIVN");

		opcodes.put("DIVI", 11);
		requiresArgument.put("DIVI", true);

		opcodes.put("NOT", 18);
		requiresArgument.put("NOT", false);

		opcodes.put("HALT", 31);
		requiresArgument.put("HALT", false);

		opcodes.put("JUMP", 26);
		requiresArgument.put("JUMP", true);

		opcodes.put("JMPN", 256+26);
		requiresArgument.put("JMPN", true);

		indirectCode.put("JUMP", "JMPN");

		opcodes.put("JMPZ", 27);
		requiresArgument.put("JMPZ", true);

		opcodes.put("JMZN", 256+27);
		requiresArgument.put("JMZN", true);

		indirectCode.put("JMPZ", "JMZN");

		opcodes.put("NOP", 0);
		requiresArgument.put("NOP", false);

		opcodes.put("AND", 16);
		requiresArgument.put("AND", true);

		opcodes.put("ANDI", 17);
		requiresArgument.put("ANDI", true);

		opcodes.put("CMPZ", 19);
		requiresArgument.put("CMPZ", true);

		opcodes.put("CMPL", 20);
		requiresArgument.put("CMPL", true);
	}//2

	//	public static void assembleFile(File inFile, File outFile){//3
	//		try {//4
	public static boolean assembleFile(File inFile, File outFile){
		boolean goodProgram = false;
		try {
			goodProgram = true;
			/* Open inFile into a Scanner */
			Scanner input = new Scanner(inFile);
			/* Open outFile into a PrintWriter output = new PrintWriter(outFile); */
			PrintWriter output = new PrintWriter(outFile);
			boolean inCode = true; //keep track that we are in the code
			int lineCounter = 0;
			//boolean goodProgram = true;
			while(goodProgram && input.hasNextLine()) {//5
				String line = input.nextLine();/*get the next line from the Scanner*/
				// increment lineCounter
				System.out.println(line);
				lineCounter++;
				// if the line is not blank do everything from here up to (1) 
				// (use line.trim().length() > 0 to check it is not blank)
				if(line.trim().length() > 0){//6

					if(line.charAt(0)==' ' || line.charAt(0)=='\t'){//7
						goodProgram = false;
						JOptionPane.showMessageDialog(null, 
								"Line starts with blank space: " + line, 
								"Error on Line " + lineCounter, 
								JOptionPane.WARNING_MESSAGE);
					}//7


					else if(line.trim().equals("--DATA--")){//8
						inCode = false;
						output.println(-1);
					}//8
					else {//9 else do everything up to (2)}

						String[] parts = line.trim().split("\\s+");
						if(inCode){//10
							if(opcodes.containsKey(parts[0])){//11
								if(requiresArgument.get(parts[0])){//12
									if(parts.length > 2){//13
										goodProgram = false; 
										JOptionPane.showMessageDialog(null, 
												"Too many arguments: " + line, 
												"Error on Line " + lineCounter, 
												JOptionPane.WARNING_MESSAGE);

									}//13
									else if (parts.length == 1){//14
										goodProgram = false; 
										JOptionPane.showMessageDialog(null, 
												"Arguments are missing: " + line, 
												"Error on Line " + lineCounter, 
												JOptionPane.WARNING_MESSAGE);
									}//14
									else{//14.5 
										if (parts[1].charAt(parts[1].length()-1)=='&'){//15

											parts[0]=indirectCode.get(parts[0]);
											parts[1]=parts[1].substring(0, parts[1].length()-1);
										}//15
										try{//16
											int op = opcodes.get(parts[0]);
											int arg = Integer.parseInt(parts[1],16);
											output.println(((long)op << 32) + arg);
										} catch (NumberFormatException ex) {
											goodProgram = false;
											JOptionPane.showMessageDialog(null, 
													"Argument that's not an int: " + line, 
													"Error on Line " + lineCounter, 
													JOptionPane.WARNING_MESSAGE);
										}//16



									}//14.5	
								}//11
								else { //17 this is the else of requiresArgument
									if(parts.length > 1) {//18
										goodProgram = false;
										JOptionPane.showMessageDialog(null, 
												"Unrequired argument: " + line, 
												"Error on Line " + lineCounter, 
												JOptionPane.WARNING_MESSAGE);
									}//18

									else {//19
										int op = opcodes.get(parts[0]);
										output.println((long)op << 32);
										System.out.println((long)op<<32);
									}//19
								}//17
							}//12
							else { //20 this is the else of opcodes.containsKey
								goodProgram = false;
								JOptionPane.showMessageDialog(null, 
										"The opcode is not recognized: " + line, 
										"Error on Line " + lineCounter, 
										JOptionPane.WARNING_MESSAGE);
							}//20

						}//10
						else { // this is the else of inCode
							if (parts.length != 2){//21
								goodProgram = false;
								JOptionPane.showMessageDialog(null, 
										"Data is not a address/value pair: " + line, 
										"Error on Line " + lineCounter, 
										JOptionPane.WARNING_MESSAGE);
							}//21

							else {
								try {
									int addr = Integer.parseInt(parts[0],16);
									int arg = Integer.parseInt(parts[1],16);
									output.println(((long)addr << 32) + arg);
									
								}  catch (NumberFormatException ex) {
									goodProgram = false;
									JOptionPane.showMessageDialog(null, 
											"The address or argument is not an int: " + line, 
											"Error on Line " + lineCounter, 
											JOptionPane.WARNING_MESSAGE);
								}//end of catch
							}//end of else
						}// (2) end of big else  
					}// (1) end of "if the line is not blank

				}
			}// end of while loop
			output.close();
			input.close(); 
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, 
					"Unable to open the necessary files", 
					"File Error",
					JOptionPane.WARNING_MESSAGE);										
		}
		if(!goodProgram && outFile != null && outFile.exists()) {
			outFile.delete();
		}
		return goodProgram;
	}
}