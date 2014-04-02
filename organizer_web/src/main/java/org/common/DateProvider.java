package org.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateProvider {

	static GregorianCalendar dateProvider = new GregorianCalendar();
	static final int firstDayOfWeek = Calendar.MONDAY;

	static public Date getFirstDayOfWeek(Date currentDate) {
		dateProvider.setTime(currentDate);

		while (firstDayOfWeek != dateProvider.get(Calendar.DAY_OF_WEEK)) {
			dateProvider.add(Calendar.DATE, -1);
		}
		return dateProvider.getTime();
	}

	static public Date getLastDayOfWeek(Date currentDate) {
		dateProvider.setTime(currentDate);
		// Roll to weeks last day using firstdayofweek. Roll until FDofW is
		// found and then roll back one day.
		while (firstDayOfWeek != dateProvider.get(Calendar.DAY_OF_WEEK)) {
			dateProvider.add(Calendar.DATE, 1);
		}
		dateProvider.add(Calendar.DATE, -1);
		return dateProvider.getTime();
	}
	
	static public Date getFirstDayOfMonth(int year, int week){
		dateProvider.set(Calendar.YEAR, year);
		dateProvider.set(Calendar.WEEK_OF_YEAR, week);
		dateProvider.set(Calendar.DAY_OF_MONTH, 1);
		return dateProvider.getTime();
	}
	
	static public Date getLastDayOfMonth(int year, int week){
		dateProvider.set(Calendar.YEAR, year);
		dateProvider.set(Calendar.WEEK_OF_YEAR, week);
		dateProvider.set(Calendar.DAY_OF_MONTH, 1);
		dateProvider.add(Calendar.MONTH, 1);
		dateProvider.add(Calendar.DATE, -1);
		return dateProvider.getTime();
	}
	
	static public Date getFirstDayOfMonth(Date currentDate){
		dateProvider.setTime(currentDate);
		dateProvider.set(Calendar.DAY_OF_MONTH, 1);
		return dateProvider.getTime();
	}
	
	static public Date getLastDayOfMonth(Date currentDate){
		dateProvider.setTime(currentDate);
		dateProvider.set(Calendar.DAY_OF_MONTH, 1);
		dateProvider.add(Calendar.MONTH, 1);
		dateProvider.add(Calendar.DATE, -1);
		return dateProvider.getTime();
	}
	
	static public Date getDateHoursLater(Date currentDate, int hours){
		dateProvider.setTime(currentDate);
		dateProvider.add(Calendar.HOUR, hours);
		return dateProvider.getTime();
		
	}
}
