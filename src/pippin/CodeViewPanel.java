package pippin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class CodeViewPanel implements Observer {

	/**
	 * @param args
	 */
	private JTextField[] actualCodeField = new JTextField[Memory.DATA_SIZE];
    private JTextField[] sourceCodeField = new JTextField[Memory.DATA_SIZE];
    private Machine machine;
    private int currentLocation = 0;

	
	public CodeViewPanel(Machine machine) {
	        this.machine = machine;
	        machine.addObserver(this);
	    }
	public JComponent createDataDisplay(){
		JPanel  returnPanel = new JPanel(new BorderLayout());
		returnPanel.add(new JLabel("Data Memory View", JLabel.CENTER), BorderLayout.PAGE_START);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel numPanel = new JPanel(new GridLayout(0,1));
		JPanel intPanel = new JPanel(new GridLayout(0,1));
		JPanel binaryPanel = new JPanel(new GridLayout(0,1));
		panel.add(numPanel);
		panel.add(intPanel);
		panel.add(binaryPanel);
		
		panel.add(numPanel, BorderLayout.LINE_START); 
		panel.add(intPanel, BorderLayout.CENTER); 
		panel.add(binaryPanel, BorderLayout.LINE_END);  
		
		for(int q=0;q<Memory.DATA_SIZE;q++)
        {
            numPanel.add(new JLabel(" "+q+": ", JLabel.RIGHT));

            actualCodeField[q]=new JTextField(10);
            intPanel.add(actualCodeField[q]);

            sourceCodeField[q]=new JTextField(30);
            binaryPanel.add(sourceCodeField[q]);
        }
		returnPanel.add(new JScrollPane(panel));
		return returnPanel;

	}
	public JComponent createCodeDisplay() {
        JPanel returnPanel = new JPanel();
        returnPanel.setLayout(new BorderLayout());
        returnPanel.add(new JLabel("Code Memory View", JLabel.CENTER),
                BorderLayout.PAGE_START);
        return returnPanel;
	}
	
	@Override
    public void update(Observable o, Object msg) {
        if ("New Program".equals(msg)) {
            for(int i = 0; i < Memory.CODE_SIZE; i++) {
                try {
                    actualCodeField[i].setText(machine.getExecutable(i));
                    sourceCodeField[i].setText(machine.getSource(i));
                } catch (CodeAccessException e) {
                    e.printStackTrace(); // i is always in bounds here
                }
            }
            currentLocation = 0;
            actualCodeField[currentLocation].setBackground(Color.YELLOW);
            sourceCodeField[currentLocation].setBackground(Color.YELLOW);
        } else if ("Clear".equals(msg)) {
// set all the fields to the empty String "" and all the background colors to WHITE
        	 for(JTextField i: actualCodeField){
        		 i.setText("");
        		 i.setBackground(Color.WHITE);
        	 }
        } else {
//set the currentLocation field background to WHITE
// change currentLocation  to machine.getIP();
// set the currentLocation field background to YELLOW
        	if(actualCodeField[currentLocation]!=null) {
        	actualCodeField[currentLocation].setBackground(Color.WHITE);
        	sourceCodeField[currentLocation].setBackground(Color.WHITE);
        	currentLocation = machine.getIP();
        	actualCodeField[currentLocation].setBackground(Color.YELLOW);
        	sourceCodeField[currentLocation].setBackground(Color.YELLOW);
        	}
       	 }
        }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
