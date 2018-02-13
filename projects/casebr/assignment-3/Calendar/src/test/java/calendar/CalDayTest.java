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
	public void test08()  throws Throwable  {
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
	/* --------ASSIGNMENT 3-------- */
	@Test //test adding appt
	public void test09()  throws Throwable  {
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
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		startHour = 2;
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		startHour = 1;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		//make sure that order is right for dates
		day.addAppt(appt1);
		day.addAppt(appt2);
		day.addAppt(appt3);
		day.addAppt(appt2);
		assertEquals(((Appt)day.getAppts().get(2)), appt2);
		assertEquals(((Appt)day.getAppts().get(0)), appt1);
		assertEquals(((Appt)day.getAppts().get(1)), appt3);
		assertNotEquals(((Appt)day.getAppts().get(0)), appt3);
	}
	@Test //test day
	public void test10()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
		CalDay day = new CalDay(calendar);
		
		assertNotNull(day.getAppts());
	}
	@Test //test day comparison
	public void test11()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,15);
		GregorianCalendar calendar2 = new GregorianCalendar(2019,5,16);
		CalDay day1 = new CalDay(calendar1);
		CalDay day2 = new CalDay(calendar2);
		
		assertNotEquals(day1.getDay(), day2.getDay());
	}
	@Test //test month comparison
	public void test12()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,15);
		GregorianCalendar calendar2 = new GregorianCalendar(2019,5,16);
		CalDay day1 = new CalDay(calendar1);
		CalDay day2 = new CalDay(calendar2);
		
		assertNotEquals(day1.getMonth(), day2.getMonth());
	}
	@Test //test month comparison
	public void test13()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,15);
		GregorianCalendar calendar2 = new GregorianCalendar(2019,5,16);
		CalDay day1 = new CalDay(calendar1);
		CalDay day2 = new CalDay(calendar2);
		
		assertNotEquals(day1.getYear(), day2.getYear());
	}
	@Test //test if statement in addAppt
	public void test14()  throws Throwable  {
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
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		startHour = 2;
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		startHour = 1;
		startMinute = 13;
		Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		//make sure that order is right for dates
		day.addAppt(appt1);
		day.addAppt(appt2);
		day.addAppt(appt3);
		day.addAppt(appt2);
		assertNotEquals(((Appt)day.getAppts().get(1)), appt1);
	}
	@Test //test toString
	public void test15()  throws Throwable  {
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
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		day.addAppt(appt1);
		//see if string has all appts
		StringBuilder sb1 = new StringBuilder();
		String todayDate = day.getMonth() + "/" + day.getDay() + "/" + day.getYear();
		sb1.append("\t --- " + todayDate + " --- \n");
		sb1.append(" --- -------- Appointments ------------ --- \n");
		sb1.append(appt1 + " \n");
		
		assertEquals(sb1.toString(), day.toString());
	}
}
