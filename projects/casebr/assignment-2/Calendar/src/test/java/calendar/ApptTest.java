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
		assertFalse(appt5.getValid());
	}
}
