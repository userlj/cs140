package lab05;

import java.util.Date;

public class Woman5 extends Person5 {

	public Woman5(String firstName, String lastName, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	public Woman5(String firstName, String lastName, String id,
			Date dateOfBirth, String cityOfBirth, String countryOfBirth) {
		super(firstName, lastName, id, dateOfBirth, cityOfBirth, countryOfBirth);
	}

	@Override
	public Gender getGender() {
		return Gender.FEMALE;
	}

}
