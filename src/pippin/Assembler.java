package pippin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

    public class Assembler
    {
       public static Map<String, Integer> opcodes = new HashMap<String, Integer>();
       public static Map<String, Boolean> requiresArgument = new HashMap<String, Boolean>();
       public static Map<String, String> indirectCode = new HashMap<String, String>();
   
       static {
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
          requiresArgument.put("AND", false);
          
          opcodes.put("ANDI", 17);
          requiresArgument.put("ANDI", false);
          
          opcodes.put("CMPZ", 19);
          requiresArgument.put("CMPZ", false);
          
          opcodes.put("CMPL", 20);
          requiresArgument.put("CMPL", false);
       }
    
   
       public static void assembleFile(File inFile, File outFile)
       {
          try {
           /* Open inFile into a Scanner */
        	  Scanner input = new Scanner(inFile);
           /* Open outFile into a PrintWriter output = new PrintWriter(outFile); */
        	  PrintWriter output = new PrintWriter(outFile);
        	  boolean goodProgram = true;
        	  boolean inCode = true; //keep track that we are in the code
        	  @SuppressWarnings("unused")
			int lineCounter = 0;
        	  while(input.hasNextLine() && goodProgram){
        		  String line = input.nextLine();
                  lineCounter++;
                  if(line.trim().length() > 0)
                  {
                	 if (line.trim().equals("--DATA--"))
                	 {
                		 inCode=false;
                		 output.println(-1);
                	 }
                	 else if(inCode)
                	 {
                		 // split the line by any white space using
                		 String[ ] parts = line.trim().split("\\s+");
                		 if(opcodes.containsKey(parts[0]))
                		 {
                			 if(requiresArgument.get(parts[0]))
                			 {
                				 try 
                				 {
                					 if(parts[1].endsWith("&"))
                					 {
                						 parts[0] = indirectCode.get(parts[0]);
                						 parts[1] = parts[1].substring(0, parts[0].length()-2);
                					 }
                					 int op = opcodes.get(parts[0]);
                					 int arg = Integer.parseInt(parts[1],16);
                					 output.println(((long)op << 32) + arg);                       
                				 } 
                				 catch(NumberFormatException e) 
                				 {
                				 }
                			 }
                			 else// if(!requiresArgument.get(parts[0]))
                			 {
                				 int op = opcodes.get(parts[0]);
                				 output.println((long)op << 32);                
                				 try 
                				 {
                					 int addr = Integer.parseInt(parts[0],16);
                					 int arg = Integer.parseInt(parts[1],16);
                					 output.println(((long)addr << 32) + arg);                
                				 } 
                				 catch(NumberFormatException e) {}
                				 output.close();                
                				 input.close();
                			 }
                		 }
                		 else//if next line is not a valid instruction
                		 {
                			 //do nothing
                		 }
                	 }
                	 else//if next line is not in the code
                	 {
                		 
                	 }
                }
        	  }
          }
          catch (IOException e){
			JOptionPane.showMessageDialog(null, 
					"Unable to open the necessary files", 
					"File Error",
					JOptionPane.WARNING_MESSAGE);	
       }
 }
 }
          