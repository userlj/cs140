package lab05;

import javax.swing.JOptionPane;

public class RandomPerson5Tester {

	public void tester1(Person5[] people) {
		//year, (month-1), day, hour, minute, second
		Random5PersonGenerator rpg = new Random5PersonGenerator();  
		StringBuilder bldr = new StringBuilder();
		for(int i = 0; i < people.length; i++) {
			people[i] = rpg.personGenerator();
			bldr.append(people[i]);
			bldr.append('\n');
		}
		JOptionPane.showMessageDialog(null,bldr);		
	}

	public void tester2(Person5[] people) {
		StringBuilder bldr = new StringBuilder();
		for(int i = 0; i < people.length; i++) {
			/* These are the parameters that are needed:
			 * @param firstName the first name of the person
			 * @param lastName the last name of the person
			 * @param dateOfBirth the date of birth of the person
			 * @param cityOfBirth the city where the person was born
			 * @param countryOfBirth the country where the person was born
			 */
			String[] birthPlace = NamesResource.getRandomBirthPlace();
			if(Math.random() > 0.5) {
				people[i] = new Woman5(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			} else {
				people[i] = new Man5(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						birthPlace[0],
						birthPlace[1]);
			}
			bldr.append(people[i]);
			bldr.append('\n');
		}
		JOptionPane.showMessageDialog(null,bldr);		
	}
	public static void main(String[] args) {
		RandomPerson5Tester test = new RandomPerson5Tester();
		test.tester1(new Person5[10]);
		test.tester2(new Person5[20]);
	}
}
