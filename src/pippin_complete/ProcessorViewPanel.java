package pippin_complete;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ProcessorViewPanel implements Observer {
	private JTextField accumulator = new JTextField();
	private JTextField programCounter = new JTextField();
	private Machine machine;

	public ProcessorViewPanel(Machine machine) {
		this.machine =machine;
		if (machine != null) machine.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		accumulator.setText(""+machine.getAcc());
		programCounter.setText(""+machine.getIP());
	}

	public JComponent createProcessorDisplay() {
		// create a JPanel called retVal
		JPanel retVal = new JPanel(new GridLayout(1,0));
		JLabel assemblerLabel = new JLabel("Assembler");
		JLabel ipLabel = new JLabel("Instruction Pointer");
		retVal.add(assemblerLabel);
		retVal.add(accumulator);
		retVal.add(ipLabel);
		retVal.add(programCounter);
		
		
		
//set it up with labels Assembler and Instruction Pointer and the text fields above.
//to get the image above, when added to the Machine's frame
		return retVal;
	}
}

