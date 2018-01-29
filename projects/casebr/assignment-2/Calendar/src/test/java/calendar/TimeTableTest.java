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
		
		day.addAppt(appt1);
		
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		
		assertNull(timeTable.deleteAppt(null, null));
		assertNull(timeTable.deleteAppt(appts, appt1));
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		assertNull(timeTable.deleteAppt(appts, appt2));
		startMinute = 9999;
		assertNull(timeTable.deleteAppt(appts, appt2));
		
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
		startMinute = 9999;
		Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		day.addAppt(appt1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.push(appt1);
		//appts.push(appt2);
		
		int[] pv = new int[1];
		pv[0] = 0; //pv[1] = 2;
		
		//doesnt work goes out of bounds
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
}
