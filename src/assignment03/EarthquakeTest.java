package assignment03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EarthquakeTest {
	Earthquake earthquake;
	/*	@Before
	public void setUp() throws Exception {
		//earthquake = new Earthquake(5.9);
	}

	@Test
	public void testEarthquake() {
		//assertNotNull("the constructor creates an object", earthquake);
	}
*/
	@Test
	public void testGetDescription1() {
		//Earthquake earthquake;
		earthquake = new Earthquake(8.5);
		assertEquals("verify that the description is \"Most structures fall", 
				"Most structures fall", earthquake.getDescription());
	}
	
	@Test
	public void testGetDescription2() {
		//Earthquake earthquake;
		earthquake = new Earthquake(7.6);
		assertEquals("verify that the description is \"Many buildings destroyed", 
				"Many buildings destroyed", earthquake.getDescription());
	}
	
	@Test
	public void testGetDescription3() {
		//Earthquake earthquake;
		earthquake = new Earthquake(6.3);
		assertEquals("verify that the description is \"Many buildings considerably damaged, some collapse", 
				"Many buildings considerably damaged, some collapse", earthquake.getDescription());
	}
	
	@Test
	public void testGetDescription4() {
		//Earthquake earthquake;
		earthquake = new Earthquake(5.1);
		assertEquals("verify that the description is \"Damage to poorly constructed buildings", 
				"Damage to poorly constructed buildings", earthquake.getDescription());
	}

	@Test
	public void testGetDescription5() {
		//Earthquake earthquake;
		earthquake = new Earthquake(3.8);
		assertEquals("verify that the description is \"Felt by many people, no destruction", 
				"Felt by many people, no destruction", earthquake.getDescription());
	}
	
	@Test
	public void testGetDescription6() {
		//Earthquake earthquake;
		earthquake = new Earthquake(1.4);
		assertEquals("verify that the description is \"Generally not felt by people", 
				"Generally not felt by people", earthquake.getDescription());
	}
	
	@Test
	public void testGetDescription7() {
		//Earthquake earthquake;
		earthquake = new Earthquake(-2.3);
		assertEquals("verify that the description is \"Negative numbers are not valid", 
				"Negative numbers are not valid", earthquake.getDescription());
	}

}
