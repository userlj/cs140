package assignment03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TaxReturnTest {
	TaxReturn taxreturn;
/*	@Before
	public void setUp() throws Exception {
		//taxreturn = new TaxReturn(80000.0, 1);
	}

	@Test
	public void testTaxReturn() {
		//taxreturn = new TaxReturn(80000.0, 1);
		//assertNotNull("the constructor creates an object", taxreturn);
		//assertEquals("verify that the tax is 20454.5", 
			//			20454.5, taxreturn.getTax(),1E-5);
	}
*/
	@Test
	public void testGetTax1() {
		taxreturn = new TaxReturn(45000.0, 1);
		assertEquals("verify that the tax is 6450.0", 
				6450.0, taxreturn.getTax(),1E-5);
	}
	
	@Test
	public void testGetTax2() {
		taxreturn = new TaxReturn(80000.0, 1);
		assertEquals("verify that the tax is 15200.0", 
				15200.0, taxreturn.getTax(),1E-5);
	}

	@Test
	public void testGetTax3() {
		taxreturn = new TaxReturn(45000.0, 2);
		assertEquals("verify that the tax is 4500.0", 
				4500.0, taxreturn.getTax(),1E-5);
	}

	@Test
	public void testGetTax4() {
		taxreturn = new TaxReturn(100000.0, 2);
		assertEquals("verify that the tax is 15400.0", 
				15400.0, taxreturn.getTax(),1E-5);
	}

}
