package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Book2HelperTest {
	Book2 book1 = new Book2("Book1", 500, true, 1);
	Book2 book2 = new Book2("Book2", 600, false, 2);
	Book2 book3 = new Book2("Book3", 550, false, 3);
	Book2 book4 = new Book2("Book4", 1100, false, 4);
	Book2 book5 = null;
	
	ArrayList<Book2> books1 = new ArrayList<Book2>();
	ArrayList<Book2> books2 = new ArrayList<Book2>();
	ArrayList<Book2> books3 = new ArrayList<Book2>();
	ArrayList<Book2> books4 = new ArrayList<Book2>();
	ArrayList<Book2> books5 = new ArrayList<Book2>();
	
	@Before
	public void setUp() throws Exception {
		//books1 equals null
		books1 = null;
		//books2 is empty
		//books3's elements are all empty
		books3.add(book5); books3.add(book5); books3.add(book5); books3.add(book5);
		//books4's elements are all not empty
		books4.add(book1); books4.add(book2); books4.add(book3); books4.add(book4);
		//books5 contains both empty and not empty elements
		books5.add(book1); books5.add(book5); books5.add(book5);
	}

	@Test
	public void test1() {
		assertNull(Book2Helper.bookWithMostPages(books1));
		assertEquals("Verify the function returns null because all the elements are null",
				null, Book2Helper.bookWithMostPages(books1));
	}
	
	@Test
	public void test2() {
		assertNull(Book2Helper.bookWithMostPages(books2));
		assertEquals("Verify the function returns null because the array is empty.",
				null, Book2Helper.bookWithMostPages(books2));
	}

	@Test
	public void test3() {
		assertNull(Book2Helper.bookWithMostPages(books3));
		assertEquals("Verify the function returns null because each element is null.",
				null, Book2Helper.bookWithMostPages(books3));
	}
	
	@Test
	public void test4() {
		assertNotNull(Book2Helper.bookWithMostPages(books4));
		assertEquals("Verify that the function returns the book that has the most pages, which is book4",
				book4, Book2Helper.bookWithMostPages(books4));
	}
	
	@Test
	public void test5() {
		assertNotNull(Book2Helper.bookWithMostPages(books5));
		assertEquals("Verify that the function returns the book that has the most pages, which is book1",
				book1, Book2Helper.bookWithMostPages(books5));
	}
}
