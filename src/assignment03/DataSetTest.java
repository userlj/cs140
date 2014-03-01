package assignment03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataSetTest {
	DataSet dataset;
	@Before
	public void setUp() throws Exception {
		dataset = new DataSet();
	}

	@Test
	public void testDataSet() {
		assertNotNull("the constructor creates an object", dataset);
		assertEquals("the initial sum is 0.0", 
						0.0, dataset.getSum(),1E-5);
		assertEquals("the initial count is 0", 
				0.0, dataset.getCount(),1E-5);
	}

	@Test
	public void testAdd() {
		double[ ] array = {1.0,2.1,3.2,4.3,5.4};
		double sum = 0.0;
		for(int i = 0; i < array.length; i++) {
			dataset.add(array[i]);
			sum += array[i];
			assertEquals("verify that the sum is correct", 
					sum, dataset.getSum(),1E-5);
			assertEquals("verify that the count is correct", 
					i+1, dataset.getCount());
			assertEquals("verify that the average is sum/(i+1)", 
					sum/(i+1), dataset.getAverage(),1E-5);
		}
	}

	@Test
	public void testGetAverage() {
		assertEquals("verify that the average is 0.0", 
				0.0, dataset.getAverage(),1E-5);
		dataset.add(1.2);
		assertEquals("verify that the average is 1.2", 
				1.2, dataset.getAverage(),1E-5);
		dataset.add(1.4);
		assertEquals("verify that the average is 1.3", 
				1.3, dataset.getAverage(),1E-5);
		dataset.add(3.4);
		assertEquals("verify that the average is 2.0", 
				2.0, dataset.getAverage(),1E-5);
	}

	@Test
	public void testGetMaximum() {
		assertEquals("verify that the maximum is correct", 
				0.0, dataset.getMaximum(),1E-5);
		dataset.add(1.2);
		assertEquals("verify that the maximum is 1.2", 
				1.2, dataset.getMaximum(),1E-5);
		dataset.add(1.4);
		assertEquals("verify that the maximum is 1.4", 
				1.4, dataset.getMaximum(),1E-5);
		dataset.add(3.4);
		assertEquals("verify that the maximum is 3.4", 
				3.4, dataset.getMaximum(),1E-5);
	}

	@Test
	public void testGetMaximum1() {
		//maximum element 5.0 is the first one in the array
		dataset.add(5.0);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
		dataset.add(1.4);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
		dataset.add(3.4);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
	}
	
	@Test
	public void testGetMaximum2() {
		//maximum element5.0 is the last one in the array
		dataset.add(1.2);
		assertEquals("verify that the maximum is 1.2", 
				1.2, dataset.getMaximum(),1E-5);
		dataset.add(1.4);
		assertEquals("verify that the maximum is 1.4", 
				1.4, dataset.getMaximum(),1E-5);
		dataset.add(5.0);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
	}
	
	@Test
	public void testGetMaximum3() {
		//one where the maximum element is neither the first nor the last in the array
		dataset.add(1.2);
		assertEquals("verify that the maximum is 1.2", 
				1.2, dataset.getMaximum(),1E-5);
		dataset.add(5.0);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
		dataset.add(2.4);
		assertEquals("verify that the maximum is 5.0", 
				5.0, dataset.getMaximum(),1E-5);
	}
}
