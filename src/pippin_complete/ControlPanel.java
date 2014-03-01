package pippin_complete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ControlPanel implements Observer {
    private Machine machine;
    private JButton stepButton = new JButton("Step");
    private JButton clearButton = new JButton("Clear");
    private JButton runButton = new JButton("Run/Pause");;
    private JButton reloadButton = new JButton("Reload");;

    public ControlPanel(Machine machine) {
        this.machine = machine;
        if (machine != null) {
            machine.addObserver(this);
        }
    }
    public void checkEnabledButtons() {
        runButton.setEnabled(machine.getState().getRunSuspendActive());
        stepButton.setEnabled(machine.getState().getStepActive());
        clearButton.setEnabled(machine.getState().getClearActive());
        reloadButton.setEnabled(machine.getState().getReloadActive());
        
        // write a similar line for the other 2 buttons for the
        // corresponding active states
        //note that the RUN entry is not used in this version of Pippin.
    }

    private class StepListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            machine.step(); // add this void method to Machine
        }
    }

    // Create an ActionListener called ClearListener that
    // calls machine.clearMemory(); from the actionPerformed method
    // and add that void method to Machine
    // Create an ActionListener called ReloadListener that calls
    // machine.reload(); from the actionPerformed method and add that
    // void method to Machine
   
    private class ClearListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		machine.clearAll();
    	}
    }
    private class ReloadListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		machine.reload();
    }
    }

    private class RunPauseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (machine.isAutoStepOn()) {
                machine.setAutoStepOn(false); // add this void method to Machine
            } else {
                machine.setAutoStepOn(true);
            }
        }
    }
    public JComponent createControlDisplay() {
// complete this code to make the bar of buttons along the bottom of the frame
// in the graphic
// ADD THE LISTENERS TO THE BUTTONS
    	 JPanel retVal=new JPanel();
         /*JLabel InstructionPointer=new JLabel("Instruction Pointer", JLabel.RIGHT);
         JLabel Accumulator=new JLabel("Accumulator", JLabel.RIGHT);
         JLabel Step=new JLabel("Step", JLabel.RIGHT);
         JLabel clear=new JLabel("Clear", JLabel.RIGHT);
         JLabel run=new JLabel("Run", JLabel.RIGHT);
         JLabel reload=new JLabel("Reload", JLabel.RIGHT);*/ 
         stepButton.addActionListener(new StepListener());
         clearButton.addActionListener(new ClearListener());
         reloadButton.addActionListener(new ReloadListener());
         runButton.addActionListener(new RunPauseListener());
    	retVal.setLayout(new GridLayout(1,0));
    	retVal.add(stepButton); 
    	retVal.add(clearButton);
    	retVal.add(reloadButton);
    	retVal.add(runButton);
    	return retVal;
    	
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        checkEnabledButtons();
    }
}