package calendar;
/**
*  This class provides a basic set of test cases for the
*  CalDay class.
*/
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	
	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
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
		
		//makes sure that a valid apointment gets added correctly
		day.addAppt(appt);
		assertEquals(1, day.getSizeAppts());
	}
	@Test
	public void test02()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
		int startHour=1;
		int startMinute=999;
		int startDay=17;
		int startMonth=4;
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
		
		//make sure an invalid apointment doesnt get added
		day.addAppt(appt);
		assertEquals(0, day.getSizeAppts());
	}

	@Test
	public void test03()  throws Throwable  {
		CalDay day = new CalDay();
		//this makes sure that an empty calDay is null
		assertNull(day.iterator());
	}
	
	@Test
	public void test04()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=4;
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
		
		//make sure iterator function returns good for valid input
		day.addAppt(appt);
		assertNotNull(day.iterator());
	}
	
	@Test
	public void test05()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
		int startHour=1;
		int startMinute=12;
		int startDay=17;
		int startMonth=4;
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
		
		//make sure gives back string since input is good
		day.addAppt(appt);
		assertNotNull(day.toString());
	}
	
	@Test
	public void test06()  throws Throwable  {
		CalDay day = new CalDay();
    //should give not null 
		assertNotNull(day.toString());
	}
	
	@Test
	public void test07()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
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
		
		startHour = 2;
		Appt appt2 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		//check to see all appointments can be added correctly
		day.addAppt(appt2);
		day.addAppt(appt);
		assertEquals(2, day.getSizeAppts());
	}
	
	@Test
	public void test078()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
		int startHour=4;
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
		
		startHour = 8;
		Appt appt2 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		startHour = 13;
		Appt appt3 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		startHour = 1;
		Appt appt4 = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title,
		description);
		
		//check to see all appointments can be added correctly
		day.addAppt(appt2);
		day.addAppt(appt);
		day.addAppt(appt3);
		day.addAppt(appt4);

		assertEquals(4, day.getAppts().size());
	}
}
