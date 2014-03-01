package ch05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class EarthquakeTest {
	Earthquake earthquake;
	@Before
	public void setUp() throws Exception {
		earthquake = new Earthquake(5.9);
	}

	@Test
	public void testEarthquake() {
		assertNotNull("the constructor creates an object", earthquake);
	}

	@Test
	public void testGetDescription() {
		assertEquals("verify that the description is \"Damage to poorly constructed buildings\"", 
				"Damage to poorly constructed buildings", earthquake.getDescription());
	}

}
