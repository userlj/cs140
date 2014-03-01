package ch05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaxReturnTest {
	TaxReturn taxreturn;
	@Before
	public void setUp() throws Exception {
		taxreturn = new TaxReturn(80000.0, 1);
	}

	@Test
	public void testTaxReturn() {
		//taxreturn = new TaxReturn(80000.0, 1);
		assertNotNull("the constructor creates an object", taxreturn);
		//assertEquals("verify that the tax is 20454.5", 
			//			20454.5, taxreturn.getTax(),1E-5);
	}

	@Test
	public void testGetTax() {
		//taxreturn = new TaxReturn(80000.0, 1);
		assertEquals("verify that the tax is 20454.5", 
				20454.5, taxreturn.getTax(),1E-5);
	}

}
