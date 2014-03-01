package lab05;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import lab04.Book2GUIListBuilder;

public class Person5ViewFrame {

	private JFrame frame = new JFrame("People");
	private Person5ViewPanel panel = new Person5ViewPanel(this); 
	private ArrayList<Person5> currentPeople = new ArrayList<Person5>();
	private JScrollPane outerPane;

	public Person5ViewFrame() {
		for(Person5 person : Person5.getRandomUSborn(100)) {
			currentPeople.add(person);
		}
		panel.setPeople(currentPeople);
	}
	
	public void createAndShowGUI() {
		outerPane = new JScrollPane(panel.createPersonView());
		frame.add(outerPane);
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Person5ViewFrame().createAndShowGUI();
			}
		});
	}

}
