package pippin;

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
//		accumulator.setText(""+machine.getAcc());
//		programCounter.setText(""+machine.getPC());
	}

	public JComponent createProcessorDisplay() {
		// create a JPanel called retVal
		JPanel retVal = new JPanel();
//set it up with labels Assembler and Instruction Pointer and the text fields above.
//to get the image above, when added to the Machine's frame
		retVal.setLayout(new GridLayout(1,0));
		retVal.add(new JLabel("accumulator", JLabel.RIGHT));
		retVal.add(accumulator);
		retVal.add(new JLabel("programCounter", JLabel.RIGHT));
		retVal.add(programCounter);
		return retVal;
	}
}