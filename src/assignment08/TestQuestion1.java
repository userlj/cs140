package assignment08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQuestion1 {
	A[] array = {new A(), new K(), new L(), new M(), new X(), new Y()};
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCountL() {
		assertEquals("verify that the number of elements instanceof L is 1", 
				1, Question1.countL(array));
	}
	
	@Test
	public void testCountX() {
		assertEquals("verify that the number of elements instanceof X is 1", 
				1, Question1.countX(array));
	}
	
	@Test
	public void testCountK() {
		assertEquals("verify that the number of elements instanceof K is 1", 
				1, Question1.countK(array));
	}
	
	@Test
	public void testCount() {
		assertEquals("verify that the number of elements instanceof A is 1", 
				1, Question1.count(A.class, array));
		assertEquals("verify that the number of elements instanceof L is 1", 
				1, Question1.count(L.class, array));
		assertEquals("verify that the number of elements instanceof K is 1", 
				1, Question1.count(K.class, array));
		assertEquals("verify that the number of elements instanceof M is 1", 
				1, Question1.count(M.class, array));
		assertEquals("verify that the number of elements instanceof X is 1", 
				1, Question1.count(X.class, array));
		assertEquals("verify that the number of elements instanceof Y is 1", 
				1, Question1.count(Y.class, array));
	}

}
