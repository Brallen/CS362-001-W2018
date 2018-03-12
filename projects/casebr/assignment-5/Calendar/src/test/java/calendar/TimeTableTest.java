package calendar;
/**
*  This class provides a basic set of test cases for the
*  TimeTable class.
*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	
	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		
		day.addAppt(appt1);
		
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		
		//breaks due to bug
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
		//this one breaks since first date is after second date
		//assertNotNull(timeTable.getApptRange(appts, calendar2, calendar1));
	}
	@Test
	public void test02()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startDay = 15;
		Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		day.addAppt(appt3);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		appts.push(appt3);
		
		assertNull(timeTable.deleteAppt(null, null));
		assertNull(timeTable.deleteAppt(null, appt1));
		assertNull(timeTable.deleteAppt(appts, null));
		assertNull(timeTable.deleteAppt(appts, appt1));
		day.addAppt(appt1);
		day.addAppt(appt3);
		appts.push(appt1);
		appts.push(appt3);
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertNull(timeTable.deleteAppt(appts, appt2));
		startMinute = 9999; //make isValid fail
		Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		day.addAppt(appt1);
		day.addAppt(appt3);
		day.addAppt(appt4);
		appts.push(appt1);
		appts.push(appt3);
		appts.push(appt4);
		assertNull(timeTable.deleteAppt(appts, appt4));
	}
	//add more unit tests as you needed
	@Test
	public void test03()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 9999; //make isValid fail
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		
		int[] pv = new int[1];
		pv[0] = 0;
		
		assertNotNull(timeTable.permute(appts, pv));
	}
	
	@Test 
	public void test04()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		int[] arr = new int[1];
		arr[0] = 1;
		appt1.setRecurrence(arr, 10, 2, 5);
		
		day.addAppt(appt1);
		
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
		//recurDays, recurBy, recurIncrement, recurNumber
		
		appt1.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 1, 1);
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
		appt1.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, 1);
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
		appt1.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 1, 1);
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
		appt1.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 1, 1);
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
	}
	
	/* -------ASSIGNMENT 3-------- */
	@Test
	public void test05()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		LinkedList<Appt> appts = new LinkedList<Appt>();
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
	}
	@Test
	public void test06()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		int[] arr = new int[1];
		arr[0] = 1;
		appt1.setRecurrence(arr, 10, 2, 5); //days
		day.addAppt(appt1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		assertNotNull(timeTable.getApptRange(appts, calendar1, calendar2));
	}
	@Test //tests getApptRange
	public void test07()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,1,1);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,2,1);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=1;
		int startDay=1;
		int startMonth=1;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 9999; //make isValid fail
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		
		assertEquals(1, timeTable.getApptRange(day.getAppts(), calendar1, calendar2).get(0).getAppts().size());
	}
	//tests permute mutations
	@Test
	public void test08()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 9999; //make isValid fail
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		
		int[] pv = new int[1];
		pv[0] = 0;
		
		assertEquals(appt1, timeTable.permute(appts, pv).get(0));
	}
	@Test
	public void test09()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startDay = 14;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 9;
		Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startMinute = 10;
		Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		day.addAppt(appt2);
		day.addAppt(appt3);
		day.addAppt(appt4);
		
		assertEquals(3, timeTable.deleteAppt(day.getAppts(), appt3).size());
	}
	@Test
	public void test10()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		GregorianCalendar calendar3 = new GregorianCalendar(2018,5,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=12;
		int startDay=12;
		int startMonth=04;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		int[] goodArr = new int[]{1,2,4};
		int[] emptyArr = new int[]{};
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		startDay = 14;
		assertEquals(0, appt1.getRecurDays().length);
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		appt2.setRecurrence(goodArr, 1,1,3);
		startMinute = 9;
		Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		appt3.setRecurrence(emptyArr, 1,1,3);
		startMinute = 11;
		Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		appt4.setRecurrence(emptyArr, 3,3,3);
		
		day.addAppt(appt1);
		LinkedList<CalDay> temp = timeTable.getApptRange(day.getAppts(), calendar1, calendar2);
		assertEquals(6, temp.size());
		day.addAppt(appt2);
		temp = timeTable.getApptRange(day.getAppts(), calendar1, calendar2);
		assertEquals(6, temp.size());
		day.addAppt(appt3);
		temp = timeTable.getApptRange(day.getAppts(), calendar1, calendar2);
		assertEquals(6, temp.size());
		day.addAppt(appt4);
		temp = timeTable.getApptRange(day.getAppts(), calendar1, calendar3);
		assertEquals(37, temp.size());
	}
	@Test
	public void test11()  throws Throwable  {
		GregorianCalendar calendar1 = new GregorianCalendar(2018,4,10);
		GregorianCalendar calendar2 = new GregorianCalendar(2018,4,16);
		CalDay day = new CalDay(calendar1);
		TimeTable timeTable=new TimeTable();
		
		int startHour=1;
		int startMinute=999;
		int startDay=12;
		int startMonth=05;
		int startYear=2018;
		String title="Meet Oprah";
		String description="Don't forget a comb";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		appt1.setRecurrence(null, 0,0,0);
		day.addAppt(appt1);
		

		assertNotNull(timeTable.getApptRange(day.getAppts(), calendar1, calendar2));
	}
}
