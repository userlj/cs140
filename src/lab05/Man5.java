package lab05;

import java.util.Date;

public class Man5 extends Person5 {

	@Override
	public Gender getGender() {
		return Gender.MALE;
	}

	public Man5(String firstName, String lastName, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	public Man5(String firstName, String lastName, String id, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, id, dateOfBirth, cityOfBirth, countryOfBirth);
	}

}
