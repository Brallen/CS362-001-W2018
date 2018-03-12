package calendar;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;


/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;
	
	/**
	* Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class
		
		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
		
		return methodArray[n] ; // return the method name 
	}

	/**
	* Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	*/
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
		
		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur 
	}	
	/**
	* Return a randomly selected appointments to recur forever or Never recur  !.
	*/
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
		
		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur 
	}	
	/**
	* Generate Random Tests that tests Appt Class.
	*/
	@Test
	public void randomtest()  throws Throwable  {
		
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		
		System.out.println("Start TimeTable testing...");
		
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				int startDay=ValuesGenerator.RandInt(random);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
				int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
				int recur=TimeTableRandomTest.RandomSelectRecur(random);
				int recurIncrement = ValuesGenerator.RandInt(random);
				int recurNumber=TimeTableRandomTest.RandomSelectRecurForEverNever(random);
				//Construct a new Appointment object with the initial data	 
				Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
				startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				startDay=ValuesGenerator.RandInt(random);
				startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				startYear=ValuesGenerator.RandInt(random);
				sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
				recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
				recur=TimeTableRandomTest.RandomSelectRecur(random);
				recurIncrement = ValuesGenerator.RandInt(random);
				recurNumber=TimeTableRandomTest.RandomSelectRecurForEverNever(random);
				Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);		   
				startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 69);
				startDay=ValuesGenerator.getRandomIntBetween(random, 0, 35);
				startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				startYear=ValuesGenerator.RandInt(random);
				sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
				recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
				recur=TimeTableRandomTest.RandomSelectRecur(random);
				recurIncrement = ValuesGenerator.RandInt(random);
				recurNumber=TimeTableRandomTest.RandomSelectRecurForEverNever(random);
				Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);		   
				appt3.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

				GregorianCalendar calendar1 = new GregorianCalendar(1,1,1);
				GregorianCalendar calendar2 = new GregorianCalendar(10,11,31);
				CalDay day = new CalDay(calendar1);
				TimeTable timeTable=new TimeTable();
				
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					day.addAppt(appt1);
					startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);
					day.addAppt(appt2);
					startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);
					day.addAppt(appt3);
					startHour=ValuesGenerator.getRandomIntBetween(random, 0, 69);

					if (methodName.equals("deleteAppt")){
						if(day.getSizeAppts() == 0) continue;
						Appt randAppt = day.getAppts().get(ValuesGenerator.getRandomIntBetween(random,0,day.getSizeAppts()-1));
						Appt badAppt = new Appt(99, 99 , 15 , 1 , 111 , "title", "description");
						int randomInt = ValuesGenerator.RandInt(random);
					  //for different parameters to be passed in
						if(randomInt < 3){
							timeTable.deleteAppt(null, null);
						}else if(randomInt >=3 && randomInt < 5){
							day.addAppt(badAppt);
							if(day.getSizeAppts() == 0) continue;
							timeTable.deleteAppt(day.getAppts(), badAppt);
						}else if(randomInt >=5 && randomInt < 8){
							if(day.getSizeAppts() == 0) continue;
							timeTable.deleteAppt(day.getAppts(), null);
						}else{
							if(day.getSizeAppts() == 0) continue;
							timeTable.deleteAppt(day.getAppts(), randAppt);
						}
					}
					else if (methodName.equals("getApptRange")){
						if(day.getSizeAppts() == 0) continue;
						Appt randAppt = day.getAppts().get(ValuesGenerator.getRandomIntBetween(random,0,day.getSizeAppts()-1));
						Appt badAppt = new Appt(99, 99 , 15 , 1 , 111 , "title", "description");
						int randomInt = ValuesGenerator.RandInt(random);
						day.addAppt(badAppt);
						timeTable.getApptRange(day.getAppts(), calendar1, calendar2);
					}
				}
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				
			}
		}catch(NullPointerException e){
			
		}
		
		System.out.println("Done TimeTable testing...");
	}
}
