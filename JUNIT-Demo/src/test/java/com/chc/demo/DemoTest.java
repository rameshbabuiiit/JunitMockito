package com.chc.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//what am I testing? Demo Class!
public class DemoTest {
	static int counter;
	Demo instanc1;
	
	@BeforeClass
	public static void initial() {
		counter = 0;
		System.out.println("Initialize before executing the first test in the class!"+"counter="+counter);
	}
	
	@AfterClass
	public static void windUp() {
		System.out.println("After Execution of all the tests in the class!"+"counter="+counter);
	}
	
	@Before
	public void beforeEachTest() {
		instanc1 = new Demo(3,5);
		System.out.println("\n	Initialize things before each test! " + instanc1);
	}
	
	@After
	public void afterEachTest() {
		counter++;
		instanc1= null;
		System.out.println("	Cleanup things after each test! " + instanc1 +"\n");
	}
	
	//Test Case 1
	@Test
	public void isEvenTest() {
		assertTrue("Even positive check!",instanc1.isEven());
	}
	
	//Test Case 2
	@Test
	public void sumTest() {
		assertEquals("Sum Positive Check",8,instanc1.sum());
	}
	
	//Test Case 3
		@Test
		public void sumTest2() {
			assertEquals("Sum Test (3+5) Check",9,instanc1.sum());
		}
}
