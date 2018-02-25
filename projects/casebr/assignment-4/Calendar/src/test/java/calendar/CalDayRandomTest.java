package calendar;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;

	/**
	* Generate Random Tests that tests CalDay Class.
	*/
	@Test
	public void randomtest()  throws Throwable  {
		
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		
		System.out.println("Start CalDay testing...");
		
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				int startHour = ValuesGenerator.getRandomIntBetween(random, 6, 16);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				//Construct new Appointments object with the initial data	 
				Appt appt = new Appt(startHour,
				startMinute, startDay, startMonth,
				startYear, title, description);
				
				//create a calDay to add appts to 
				GregorianCalendar calendar = new GregorianCalendar(2018,4,15);
				CalDay day = new CalDay(calendar);
				day.addAppt(appt);
				
				for (int i = 0; i < NUM_TESTS; i++) {
					startHour = ValuesGenerator.getRandomIntBetween(random, 6, 16);
					startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
					startDay=ValuesGenerator.RandInt(random);;
					startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					startYear=ValuesGenerator.RandInt(random);
					Appt appt2 = new Appt(startHour,
					startMinute, startDay, startMonth,
					startYear, title, description);
					day.addAppt(appt2);
				}
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				
			}
		}catch(NullPointerException e){
			
		}
		
		System.out.println("Done CalDay testing...");
	}
}
