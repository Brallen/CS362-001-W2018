package calendar;
/**
*  This class provides a basic set of test cases for the
*  Appt class.
*/
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	* Test that the gets methods work as expected.
	*/
	@Test //tests making event
	public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());         		
	}
	
	@Test //test setting after made
	public void test02()  throws Throwable  {
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		//check the set functions
		appt.setStartHour(4);
		appt.setStartMinute(1);
		appt.setStartDay(20);
		appt.setStartMonth(11);
		appt.setStartYear(2020);
		appt.setTitle("Vote");
		appt.setDescription("Kanye for prez 2020");
		assertTrue(appt.getValid());
		assertEquals(4, appt.getStartHour());
		assertEquals(1, appt.getStartMinute());
		assertEquals(20, appt.getStartDay());
		assertEquals(11, appt.getStartMonth());
		assertEquals(2020, appt.getStartYear());
		assertEquals("Vote", appt.getTitle());
		//this test wont run cause you can't pass null in anyways
		//assertEquals("", appt.setTitle(null));
		assertEquals("Kanye for prez 2020", appt.getDescription());
	}
	
	@Test //tests recurring 
	public void test03()  throws Throwable  {
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		appt.setRecurrence(null, 10, 2, 5); //no days
		assertEquals(5, appt.getRecurNumber());
		assertEquals(10, appt.getRecurBy());
		assertArrayEquals(new int[0], appt.getRecurDays());
		assertEquals(2, appt.getRecurIncrement());
		
		
		int[] arr = new int[1];
		arr[0] = 1;
		appt.setRecurrence(arr, 10, 2, 5); //days
		assertEquals(1, appt.getRecurDays()[0]);
		
		assertTrue(appt.isRecurring()); //is recurring?
		
	}	
	@Test //tests representation
	public void test04()  throws Throwable  {
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		Appt appt2 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		startHour = 12;
		Appt appt3 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		startHour = 9999;
		Appt appt4 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		
		assertNull(appt4.toString());
		assertNotNull(appt3.toString());
		assertEquals(appt1.toString(), appt2.toString());
		assertEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
	}
	
	@Test //tests isValid
	public void test05()  throws Throwable  {
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
		
		startHour = 24;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertFalse(appt2.getValid());
		
		startHour = 1;
		startMinute = 60;
		Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertFalse(appt3.getValid());
		
		startMinute = 0;
		startDay = 1000;
		Appt appt8 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertFalse(appt8.getValid());
		
		startDay = 0;
		Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertFalse(appt4.getValid());
		
		startDay = 17;
		startMonth = 12;
		//this will fail because of an out of bounds error from getting the days in the month
		Appt appt5 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt5.getValid());
	}
	
	
	/* --------ASSIGNMENT 3 CODE-------- */
	@Test //tests mutated isValid
	public void test06()  throws Throwable  {
		int startHour=0;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//invalid start hour
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated isValid
	public void test07()  throws Throwable  {
		int startHour=23;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//valid start hour
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated isValid
	public void test08()  throws Throwable  {
		int startHour=23;
		int startMinute=0;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//Valid start minute
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated isValid
	public void test09()  throws Throwable  {
		int startHour=23;
		int startMinute=59;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//Valid start minute
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated isValid
	public void test10()  throws Throwable  {
		int startHour=23;
		int startMinute=59;
		int startDay=1;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//Valid start day lower bound
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated isValid
	public void test11()  throws Throwable  {
		int startHour=23;
		int startMinute=59;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		
		//Valid start day upper bound
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated represntationApp
	public void test12()  throws Throwable  {
		int startHour=23;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//this is a bug it should return pm
		String output = "\t4/30/2070 at 11:50pm ,Meet Oprah, Don't forget a comb\n";
		assertEquals(output, appt1.toString());
	}
	@Test //tests mutated represntationApp
	public void test13()  throws Throwable  {
		int startHour=11;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//check switching from am to pm
		String output = "\t4/30/2070 at 11:50am ,Meet Oprah, Don't forget a comb\n";
		assertEquals(output, appt1.toString());
	}
	@Test //tests mutated represntationApp
	public void test14()  throws Throwable  {
		int startHour=10;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startHour=11;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//bad start hour
		assertNotEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
		assertTrue(appt1.compareTo(appt2) < appt2.compareTo(appt1));
	}
	@Test //tests mutated represntationApp
	public void test15()  throws Throwable  {
		int startHour=10;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 55;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//bad start minute
		assertNotEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
		assertTrue(appt1.compareTo(appt2) < appt2.compareTo(appt1));
	}
	@Test //tests mutated represntationApp
	public void test16()  throws Throwable  {
		int startHour=10;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startDay = 29;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//bad start day
		assertNotEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
		assertTrue(appt1.compareTo(appt2) > appt2.compareTo(appt1));
	}
	@Test //tests mutated represntationApp
	public void test17()  throws Throwable  {
		int startHour=10;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMonth = 06;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//bad start month
		assertNotEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
		assertTrue(appt1.compareTo(appt2) < appt2.compareTo(appt1));
	}
	@Test //tests mutated represntationApp
	public void test18()  throws Throwable  {
		int startHour=10;
		int startMinute=50;
		int startDay=30;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startYear = 2071;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		//bad start year
		assertNotEquals(appt1.compareTo(appt2), appt2.compareTo(appt1));
		assertTrue(appt1.compareTo(appt2) < appt2.compareTo(appt1));
	}
	@Test //tests mutated SetStartHour
	public void test19()  throws Throwable  {
		int startHour = 10;
		int startMinute = 50;
		int startDay = 30;
		int startMonth = 04;
		int startYear = 2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	  assertTrue(appt1.getValid());
		appt1.setStartHour(-1); //invalid hour check
		assertFalse(appt1.getValid());
	}
	@Test //tests mutated SetStartDay
	public void test20()  throws Throwable  {
		int startHour = 10;
		int startMinute = 50;
		int startDay = 30;
		int startMonth = 04;
		int startYear = 2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	  assertTrue(appt1.getValid());
		appt1.setStartDay(-1); //invalid day check
		assertFalse(appt1.getValid());
	}
	@Test //tests mutated SetStartMinute
	public void test21()  throws Throwable  {
		int startHour = 10;
		int startMinute = 50;
		int startDay = 30;
		int startMonth = 04;
		int startYear = 2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	  assertTrue(appt1.getValid());
		appt1.setStartMinute(99); //invalid Minute check
		assertFalse(appt1.getValid());
	}
	@Test //tests mutated SetStartMonth
	public void test22()  throws Throwable  {
		int startHour = 10;
		int startMinute = 50;
		int startDay = 30;
		int startMonth = 04;
		int startYear = 2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	  assertTrue(appt1.getValid());
		appt1.setStartMonth(1); //valid month check
		assertTrue(appt1.getValid());
	}
	@Test //tests mutated SetStartYear
	public void test23()  throws Throwable  {
		int startHour = 10;
		int startMinute = 50;
		int startDay = 30;
		int startMonth = 04;
		int startYear = 2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	  assertTrue(appt1.getValid());
		appt1.setStartYear(-1); //all years are valid years
		assertTrue(appt1.getValid());
	}
	
	@Test //tests mutated recurring 
	public void test25()  throws Throwable  {
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=04;
		int startYear=2070;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);

		assertEquals(2, appt.getRecurBy());
	}	
}

