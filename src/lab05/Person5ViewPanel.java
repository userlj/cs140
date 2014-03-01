package lab05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Person5ViewPanel {
	private ArrayList<Person5> people;
	private ArrayList<JTextField> firstNameFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> lastNameFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> idFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> dobFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> cityBirthFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> countryBirthFields = new ArrayList<JTextField>();

	private Person5ViewFrame parentView;
	
	private int rowHighLight = -1;
	private boolean mouseClickToggle = false;
	private static DateFormat dateFormatter = 
			DateFormat.getDateInstance(
					DateFormat.SHORT, new Locale("en","US"));
		
	public Person5ViewPanel(Person5ViewFrame arg) {
		parentView = arg;
	}

	public ArrayList<Person5> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person5> people) {
		this.people = people;
	}

	public JPanel createPersonView() {
		JPanel mainPanel = new JPanel();
		JPanel left = new JPanel();		
		JPanel center = new JPanel();
		JPanel right = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		left.setLayout(new GridLayout(0,2));
		center.setLayout(new GridLayout(0,2));
		right.setLayout(new GridLayout(0,2));
				
		mainPanel.add(left, BorderLayout.LINE_START);
		mainPanel.add(center, BorderLayout.CENTER);
		mainPanel.add(right, BorderLayout.LINE_END);
		
		JButton b;
		left.add(b = new JButton("Id"));
		b.addActionListener(new IdSortListener());
		left.add(b = new JButton("Date of Birth"));
		b.addActionListener(new DOBSortListener());

		center.add(b = new JButton("First Name"));
		b.addActionListener(new FirstNameSortListener());
		center.add(b = new JButton("Last Name"));
		b.addActionListener(new LastNameSortListener());
		
		right.add(b = new JButton("City of Birth"));
		b.addActionListener(new CityOfBirthSortListener());
		right.add(b = new JButton("Country of Birth"));
		b.addActionListener(new CountryOfBirthSortListener());
		
		int rowCount = 0;
		for(Person5 person : people) {
			JTextField field;
			idFields.add(field = new JTextField(6));
			left.add(field);
			field.setText(person.getId());
			field.addMouseListener(new RowMouseFocusListener(rowCount));
			dobFields.add(field = new JTextField(6));
			left.add(field);
			field.setText(dateFormatter.format(person.getDateOfBirth()));
			field.addMouseListener(new RowMouseFocusListener(rowCount));

			firstNameFields.add(field = new JTextField(10));
			center.add(field);
			field.setText(person.getFirstName());
			field.addMouseListener(new RowMouseFocusListener(rowCount));
			lastNameFields.add(field = new JTextField(10));
			center.add(field);
			field.setText(person.getLastName());
			field.addMouseListener(new RowMouseFocusListener(rowCount));
			
			cityBirthFields.add(field = new JTextField(10));
			right.add(field);
			field.setText(person.getCityOfBirth());
			field.addMouseListener(new RowMouseFocusListener(rowCount));
			countryBirthFields.add(field = new JTextField(10));
			right.add(field);
			field.setText(person.getCountryOfBirth());
			field.addMouseListener(new RowMouseFocusListener(rowCount));
			rowCount++;
		}			
		
		return mainPanel;
	}

	private class RowMouseFocusListener extends MouseAdapter {
		private int row;
		public RowMouseFocusListener(int row) {
			this.row = row;
		}	
		@Override
		public void mouseClicked(MouseEvent arg0) {
		// I AM NOT HAPPY WITH THIS YET BIT NEED A BIT MORE TIME
			if (rowHighLight >= 0) {
				firstNameFields.get(rowHighLight).setBackground(Color.WHITE);
				lastNameFields.get(rowHighLight).setBackground(Color.WHITE);
				dobFields.get(rowHighLight).setBackground(Color.WHITE);
				idFields.get(rowHighLight).setBackground(Color.WHITE);		
				cityBirthFields.get(rowHighLight).setBackground(Color.WHITE);	
				countryBirthFields.get(rowHighLight).setBackground(Color.WHITE);	
			}
			if(row == rowHighLight) {
				mouseClickToggle = !mouseClickToggle;
			}
			rowHighLight = row;
			if(mouseClickToggle) {
				firstNameFields.get(rowHighLight).setBackground(Color.YELLOW);
				lastNameFields.get(rowHighLight).setBackground(Color.YELLOW);
				dobFields.get(rowHighLight).setBackground(Color.YELLOW);
				idFields.get(rowHighLight).setBackground(Color.YELLOW);							
				cityBirthFields.get(rowHighLight).setBackground(Color.YELLOW);	
			countryBirthFields.get(rowHighLight).setBackground(Color.YELLOW);	
			}
		}		
	}
	
	private class FirstNameSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.FirstNameComp());
			parentView.createAndShowGUI();
		}
	}

	private class DOBSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.DOBComp());
			parentView.createAndShowGUI();
		}
	}
	
	private class LastNameSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.LastNameComp());
			parentView.createAndShowGUI();
		}
	}
	
	private class CityOfBirthSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.CityOfBirthComp());
			parentView.createAndShowGUI();
		}
	}
	
	private class CountryOfBirthSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.CountryOfBirthComp());
			parentView.createAndShowGUI();
		}
	}
	
	private class IdSortListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Collections.sort(people, new Person5.IdComp());
			parentView.createAndShowGUI();
		}
	}
}
