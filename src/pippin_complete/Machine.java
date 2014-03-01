package pippin_complete;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Observable;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * 
 * @author Team Jedi
 * May the Force be with you!
 * 
 */
public class Machine extends Observable {
	public final Instruction[] INSTRUCTION_SET = new Instruction[284];
	private Processor proc = new Processor();
	private Memory memory = new Memory();
	private boolean running = false;
	private boolean autoStepOn = false;
	private File currentlyExecutingFile = null;
	private States state;
	private CodeViewPanel codeViewPanel;
	private DataViewPanel dataViewPanel;
	private ControlPanel controlPanel;
	private ProcessorViewPanel processorPanel;
	private MenuBarBuilder menuBuilder;
	private JFrame frame;

	private String sourceDir;
	private String executableDir;
	private String eclipseDir;
	private Properties properties = null;
	private Loader loader;
	private static final int TICK = 500; // timer tick = 1/2 second
	/**
	 * Assigns the instruction set 
	 * creates the GUI by packing everything together
	 */
	public Machine() {
		INSTRUCTION_SET[0] = new NOP(proc, memory);
		INSTRUCTION_SET[1] = new LOD(proc, memory);
		INSTRUCTION_SET[2] = new LODI(proc, memory);
		INSTRUCTION_SET[3] = new STO(proc, memory);
		INSTRUCTION_SET[4] = new ADD(proc, memory);
		INSTRUCTION_SET[5] = new SUB(proc, memory);
		INSTRUCTION_SET[6] = new MUL(proc, memory);
		INSTRUCTION_SET[7] = new DIV(proc, memory);
		INSTRUCTION_SET[8] = new ADDI(proc, memory);
		INSTRUCTION_SET[9] = new SUBI(proc, memory);
		INSTRUCTION_SET[10] = new MULI(proc, memory);
		INSTRUCTION_SET[11] = new DIVI(proc, memory);
		INSTRUCTION_SET[16] = new AND(proc, memory);
		INSTRUCTION_SET[17] = new ANDI(proc, memory);
		INSTRUCTION_SET[18] = new NOT(proc, memory);
		INSTRUCTION_SET[19] = new CMPZ(proc, memory);
		INSTRUCTION_SET[20] = new CMPL(proc, memory);
		INSTRUCTION_SET[26] = new JUMP(proc, memory);
		INSTRUCTION_SET[27] = new JMPZ(proc, memory);
		INSTRUCTION_SET[31] = new HALT(proc, memory);
		INSTRUCTION_SET[257] = new LDN(proc, memory);
		INSTRUCTION_SET[259] = new STN(proc, memory);
		INSTRUCTION_SET[260] = new ADDN(proc, memory);
		INSTRUCTION_SET[261] = new SUBN(proc, memory);
		INSTRUCTION_SET[262] = new MULN(proc, memory);
		INSTRUCTION_SET[263] = new DIVN(proc, memory);
		INSTRUCTION_SET[282] = new JMPN(proc, memory);
		INSTRUCTION_SET[283] = new JMZN(proc, memory);
		loader = new Loader(memory);  // <<<<<<<<<<<<<THIS IS A CORRECTION>>>>>>>>>>>>>>>>>
		// CODE TO DISCOVER THE ECLIPSE DEFAULT DIRECTORY:
		File temp = new File("propertyfile.txt");
		if(!temp.exists()) {
			PrintWriter out;
			try {
				out = new PrintWriter(temp);
				out.close();
				eclipseDir = temp.getAbsolutePath();
				temp.delete();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			eclipseDir = temp.getAbsolutePath();
		}
		// change to forward slashes
		eclipseDir = eclipseDir.replace('\\','/');
		int lastSlash = eclipseDir.lastIndexOf('/');
		eclipseDir  = eclipseDir.substring(0, lastSlash + 1);
		System.out.println(eclipseDir);           
		try { // load properties file "propertyfile.txt", if it exists
			properties = new Properties();
			properties.load(new FileInputStream("propertyfile.txt"));
			sourceDir = properties.getProperty("SourceDirectory");
			executableDir = properties.getProperty("ExecutableDirectory");
			// CLEAN UP ANY ERRORS IN WHAT IS STORED:
			if (sourceDir == null || sourceDir.length() == 0
					|| !new File(sourceDir).exists()) {
				sourceDir = eclipseDir;
			}
			if (executableDir == null || executableDir.length() == 0
					|| !new File(executableDir).exists()) {
				executableDir = eclipseDir;
			}
			//catches the exception
		} catch (Exception e) {
			// PROPERTIES FILE DID NOT EXIST
			sourceDir = eclipseDir;
			executableDir = eclipseDir;
		}
		createAndShowGUI();
	}
	/**
	 * Gets the Data
	 * @param i index
	 * @return str string of data
	 * @throws DataAccessException
	 * 
	 */
	public int getData(int i) throws DataAccessException {
		return memory.getData(i);
	}
	/**
	 * Gets the Data in Binary
	 * @param location where the pointer is
	 * @return str string of binary
	 * @throws DataAccessException
	 */
	public String getDataBinary(int location) throws DataAccessException {
		int value = memory.getData(location);
		String str = "00000000000000000000000000000000" +
				Integer.toBinaryString(value);
		str = str.substring(str.length()-32);
		return str;
	}  
	/**
	 * Steps through the instruction step by step
	 * 
	 */

	public void step(){

		long binary;
		Instruction instr;
		instr = null;
		try {

			binary = memory.getCode(this.getIP());
			int high = (int)(binary >> 32);
			int arg = (int)(-1 & binary);
			instr = INSTRUCTION_SET[high];
			System.out.println(instr+ " "+arg);

			// use the same code as in getExecutable to get instr from binary

			if(instr.toString().equals("HALT")) {
				setRunning(false);
			} else {
				instr.execute(arg);
				setChanged();
				notifyObservers("Step");
			}
		} catch (CodeAccessException e) {
			JOptionPane.showMessageDialog(null,
					"There was a code access exception executing " + instr,
					"Error on code line " + this.getIP(),
					JOptionPane.WARNING_MESSAGE);
			setRunning(false);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(null,
					// similar to above but it is data access
					"There was a data access exception executing " + instr,
					"Error on data line " + this.getIP(),
					JOptionPane.WARNING_MESSAGE);
			setRunning(false);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,
					// similar to above but it is NullPointerException
					"There was a null pointer exception executing " + instr,
					"Error on code line " + this.getIP(),
					JOptionPane.WARNING_MESSAGE);
			setRunning(false);
		} catch (DivideByZeroException e) {
			JOptionPane.showMessageDialog(null,
					// similar to above but it is was caused by dividing by zero
					"It was caused by dividing by zero " + instr,
					"Error on code line " + this.getIP(),
					JOptionPane.WARNING_MESSAGE);
			setRunning(false);
		}

		setChanged();
		notifyObservers();
		
	}
	/**
	 * Checks to see if Run/Pause button is pressed
	 * @return autoStepOn essential for run/pause 
	 */
	public boolean isAutoStepOn() {
		return autoStepOn;
	}
	/**
	 * Gets the state of the program
	 * @return getState If run/pause if on or off
	 */
	public States getState() {
		return state;
	}
	/**
	 * Gets the location of the accumulator number
	 * @return proc.getAccumulator for Accumulator number
	 */
	public int getAcc(){
		return proc.getAccumulator(); 
	}
	/**
	 * Gets the instruction pointer
	 * @return proc.getInstructionPointer Where is the program at
	 */
	public int  getIP(){
		return proc.getInstructionPointer(); 
	}
	/**
	 * sets the auto step when run/pause button is pressed 
	 * @param b if true sets Auto Step on
	 */
	public void setAutoStepOn(boolean b) {
		autoStepOn = b;
		if(autoStepOn) {
			state = States.AUTO_STEPPING;
			state.enter();
			setChanged();
			notifyObservers();
		} else {
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
			state.enter();
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * Sets the state as required by the user
	 * @param state sets the state
	 */
	public void setState(States state) {
		this.state = state;
	}
	/**
	 * 
	 * @param i is the index
	 * @return inst.toString() returns error
	 * @throws CodeAccessException 
	 */

	public String getExecutable(int i) throws CodeAccessException {
		long binary = memory.getCode(i);
		int high = (int)(binary >> 32);
		int arg = (int)(-1 & binary);
		Instruction inst = INSTRUCTION_SET[high];
		return inst.toString() + " " + arg;
	}
	/**
	 * Gets the Pips file and starts conversion to .pipe type
	 * @param i is index
	 * @return returns toString
	 * @throws CodeAccessException
	 */
	public String getSource(int i) throws CodeAccessException {
		long binary = memory.getCode(i);
		int high = (int)(binary >> 32);
		int arg = (int)(-1 & binary);
		Instruction inst = INSTRUCTION_SET[high];
		if(high>256){
			return INSTRUCTION_SET[high - 256].toString() + arg;
		}   
		else{
			return inst.toString() + " " + arg;
		}
	}
	/**
	 * Assembles the file from the pips
	 */

	public void assembleFile() {
		File source = null;
		File outputExe = null;
		JFileChooser chooser = new JFileChooser(sourceDir);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Pippin Source Files", "pips");
		chooser.setFileFilter(filter);
		// CODE TO LOAD DESIRED FILE
		int openOK = chooser.showOpenDialog(null);
		if(openOK == JFileChooser.APPROVE_OPTION) {
			source = chooser.getSelectedFile();
		}
		if(source != null && source.exists()) {
			// CODE TO REMEMBER WHICH DIRECTORY HAS THE pipe FILES
			// WHICH WE WILL ALLOW TO BE DIFFERENT
			sourceDir = source.getAbsolutePath();
			sourceDir = sourceDir.replace('\\','/');
			int lastDot = sourceDir.lastIndexOf('.');
			String outName = sourceDir.substring(0, lastDot + 1) + "pipe";           
			int lastSlash = sourceDir.lastIndexOf('/');
			sourceDir = sourceDir.substring(0, lastSlash + 1);
			outName = outName.substring(lastSlash+1);
			filter = new FileNameExtensionFilter(
					"Pippin Executable Files", "pipe");
			if(executableDir.equals(eclipseDir)) {
				chooser = new JFileChooser(sourceDir);
			} else {
				System.out.println(executableDir);
				System.out.println(outName);
				chooser = new JFileChooser(executableDir);
			}
			chooser.setFileFilter(filter);
			chooser.setSelectedFile(new File(outName));
			int saveOK = chooser.showSaveDialog(null);
			if(saveOK == JFileChooser.APPROVE_OPTION) {
				outputExe = chooser.getSelectedFile();
			}
			if(outputExe != null) {
				executableDir = outputExe.getAbsolutePath();
				executableDir = executableDir.replace('\\','/');
				lastSlash = executableDir.lastIndexOf('/');
				executableDir = executableDir.substring(0, lastSlash + 1);
				try {
					properties.setProperty("SourceDirectory", sourceDir);
					properties.setProperty("ExecutableDirectory", executableDir);
					properties.store(new FileOutputStream("propertyfile.txt"),
							"File locations");
				} catch (Exception e) {
					System.out.println("Error writing properties file");
				}
				if (Assembler.assembleFile(source, outputExe)) {
					JOptionPane.showMessageDialog(
							frame, 
							"The source was assembled to an executable",
							"Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// a warning JOption pane indicating failure and that the output file was not created.
					JOptionPane.showMessageDialog(
							frame, 
							"output file was not created",
							"Warning",
							JOptionPane.INFORMATION_MESSAGE);
				}            
			} else {// outputExe still null
				JOptionPane.showMessageDialog(
						frame,
						"The output file has problems.\n" +
								"Cannot assemble the program",
								"Warning",
								JOptionPane.OK_OPTION);
			}
		} else {// outputExe does not exist
			JOptionPane.showMessageDialog(
					frame,
					"The source file has problems.\n" +
							"Cannot assemble the program",
							"Warning",
							JOptionPane.OK_OPTION);               
		}
	}
	/**
	 * loads the assembled pipe file
	 */
	public void loadFile() {
		JFileChooser chooser = new JFileChooser(executableDir);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Pippin Executable Files", "pipe");
		chooser.setFileFilter(filter);
		// CODE TO LOAD DESIRED FILE
		int openOK = chooser.showOpenDialog(null);
		if(openOK == JFileChooser.APPROVE_OPTION) {
			currentlyExecutingFile = chooser.getSelectedFile();
		}
		if(currentlyExecutingFile != null && currentlyExecutingFile.exists()) {
			// CODE TO REMEMBER WHICH DIRECTORY HAS THE pipe FILES
			executableDir = currentlyExecutingFile .getAbsolutePath();
			executableDir = executableDir.replace('\\','/');
			int lastSlash = executableDir.lastIndexOf('/');
			executableDir = executableDir.substring(0, lastSlash + 1);
			try {
				properties.setProperty("SourceDirectory", sourceDir);
				properties.setProperty("ExecutableDirectory", executableDir);
				properties.store(new FileOutputStream("propertyfile.txt"),
						"File locations");
			} catch (Exception e) {
				System.out.println("Error writing properties file");
			}    
			finalLoad_ReloadStep();       
		}

	}       
	/**
	 * If b is true then it's running if not it isn't
	 * @param b is true or false and sets running
	 */
	public void setRunning(boolean b) {
		running = b;
		if(running) {
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
			state.enter();
			setChanged();
			notifyObservers("New Program"); 
			// same as below but do NOT change autoStepOn and the new
			// state is PROGRAM_LOADED_NOT_AUTOSTEPPING;
			// also call notifyObservers with the argument "New Program"
		} else {
			autoStepOn = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();           
		}
	}
	/**
	 * Checks to see if assembled file has problems
	 */
	private void finalLoad_ReloadStep() {
		try {
			loader.load(currentlyExecutingFile);
			System.out.println(Arrays.toString(memory.getData()));

			setRunning(true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					frame,
					"The file being selected has problems.\n" +
							"Cannot load the program",
							"Warning",
							JOptionPane.OK_OPTION);
		}       
	}

/**
 * executes instructions while running is true
 */

	public void execute() {
		while(running) {
			long binary;
			Instruction instr;
			instr = null;
			try {

				binary = memory.getCode(this.getIP());
				int high = (int)(binary >> 32);
				int arg = (int)(-1 & binary);
				instr = INSTRUCTION_SET[high];

				// use the same code as in getExecutable to get instr from binary

				if(instr.toString().equals("HALT")) {
					setRunning(false);
				} else {
					instr.execute(arg);
				}
			} catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(null,
						"There was a code access exception executing " + instr,
						"Error on code line " + this.getIP(),
						JOptionPane.WARNING_MESSAGE);
				setRunning(false);
			} catch (DataAccessException e) {
				JOptionPane.showMessageDialog(null,
						// similar to above but it is data access
						"There was a data access exception executing " + instr,
						"Error on data line " + this.getIP(),
						JOptionPane.WARNING_MESSAGE);
				setRunning(false);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						// similar to above but it is NullPointerException
						"There was a null pointer exception executing " + instr,
						"Error on code line " + this.getIP(),
						JOptionPane.WARNING_MESSAGE);
				setRunning(false);
			} catch (DivideByZeroException e) {
				JOptionPane.showMessageDialog(null,
						// similar to above but it is was caused by dividing by zero
						"It was caused by dividing by zero " + instr,
						"Error on code line " + this.getIP(),
						JOptionPane.WARNING_MESSAGE);
				setRunning(false);
			}

		}
		setChanged();
		notifyObservers();
	}
	/**
	 * Works for the clear button in program clears all the texts
	 */
	public void clearAll(){
		//clearData and clearCode of memory and sets the fields of proc to 0.
		memory.clearData();
		memory.clearCode();
		proc.setAccumulator(0);
		proc.setInstructionPointer(0);
		state = States.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers("Clear");
	}
/**
 * clears the memory
 */
	public void clearMemory(){
		//clearData and clearCode of memory and sets the fields of proc to 0.
		memory.clearData();
		memory.clearCode();
		//state = States.NOTHING_LOADED;
		//state.enter();
		setChanged();
		notifyObservers("Clear Memory");
	}
/**
 * reloads the assembled file 
 */
	public void reload() {
		clearAll();
		finalLoad_ReloadStep();
	}
	/**
	 * Method that sets up the whole GUI and locates the individual
	 * components into place. Also sets up the Menu bar. Starts a 
	 * swing timer ticking.
	 */
	private void createAndShowGUI() {
		codeViewPanel = new CodeViewPanel(this);
		dataViewPanel = new DataViewPanel(this);
		controlPanel = new ControlPanel(this);
		processorPanel = new ProcessorViewPanel(this);
		menuBuilder = new MenuBarBuilder(this);
		frame = new JFrame("Pippin Simulator");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.BLACK);
		frame.setSize(800,600); // <<<<<<<<<<<<<<<<CHANGE HERE>>>>>>>>>>>>

		frame.add(codeViewPanel.createCodeDisplay(),BorderLayout.CENTER);
		frame.add(dataViewPanel.createDataDisplay(),BorderLayout.LINE_END);
		frame.add(controlPanel.createControlDisplay(),BorderLayout.PAGE_END);
		frame.add(processorPanel.createProcessorDisplay(),BorderLayout.PAGE_START);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		bar.add(menuBuilder.createMenu());
		bar.add(menuBuilder.createMenu2()); // <<<<<<<<<<<<<<<<CHANGE HERE>>>>>>>>>>>>

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new ExitAdapter());
		state = States.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers();
		javax.swing.Timer timer = new javax.swing.Timer(TICK, new TimerListener());
		timer.start();
		frame.setVisible(true);
	}
	/**
	 * exits the program
	 */
	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame,
				"Do you really wish to exit?",
				"Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	/**
	 * closes window when program exists
	 */
	private class ExitAdapter extends WindowAdapter {

		@Override
		/**
		 * if window closing is there it closes
		 */
		public void windowClosing(WindowEvent arg0) {
			exit();
		}
	}
/**
 * 
 *listens to the timer
 *
 */
	private class TimerListener implements ActionListener {
		//	private boolean autoStepOn;


		@Override
		public void actionPerformed(ActionEvent e) {
			if(autoStepOn) {
				step();
			}
		}
	} 
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Machine();
			}
		});
	}

}