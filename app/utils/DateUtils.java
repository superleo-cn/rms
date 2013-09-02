package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * DateUtils
 * 
 * @since Jun 13, 2008
 */
public class DateUtils {

	private static Logger logger = Logger.getLogger(DateUtils.class);
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	public static final String DATE_FORMATY = "yyyy/MM/dd";
	public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm";
	public static final String ORA_DATE_FORMAT = "yyyyMMdd";
	public static final String ORA_DATE_FORMAT_SIMPLE = "yyMMdd";
	public static final String ORA_DATE_TIME_FORMAT = "yyyyMMddHHmm";
	public static final String ORA_DATE_TIMES_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmssSSS";
	public static final String ORA_DATES_FORMAT = "yyyy-MM-dd";
	public static final String ORA_DATE_SIMPLE_TIMES_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final int dayArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private DateUtils() {
	}

	public static Date StringToDate(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat();
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (Exception e) {
			logger.error("DateUtils.StringToDate error!", e);
		}
		return date;
	}

	/**
	 * String to Date
	 * 
	 * @param dateString
	 *            parseStr
	 * @param partten
	 *            format yyyy-MM-dd
	 * @since Jun 13, 2008
	 */
	public static Date StringToDate(String dateString, String partten) {
		SimpleDateFormat df = new SimpleDateFormat(partten);
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (Exception e) {
			logger.error("DateUtils.StringToDate error!", e);
		}
		return date;
	}
	
	/**
	 * String to Date
	 * 
	 * @param dateString
	 *            parseStr
	 * @param partten
	 *            format yyyy-MM-dd
	 * @since Jun 13, 2008
	 */
	public static Date toDateTimeAtStartOfDay(Date date, String partten) {
		return DateUtils.StringToDate(DateUtils.toString(date, partten), partten);
	}
	

	/**
	 * Date to String
	 * 
	 * @param date
	 *            Date
	 * @param partten
	 *            yyyy-MM-dd
	 * @since Jun 13, 2008
	 */
	public static String toString(Date date, String partten) {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat df = new SimpleDateFormat(partten);
			return df.format(date);
		}
	}

	/**
	 * String to Calendar
	 * 
	 * @param dateString
	 *            parseStr
	 * @param partten
	 *            yyyy-MM-dd
	 * @since Jun 13, 2008
	 */
	public static Calendar parseCalendarFormat(String dateString, String pattern) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		Calendar cal = null;
		simpledateformat.applyPattern(pattern);
		try {
			simpledateformat.parse(dateString);
			cal = simpledateformat.getCalendar();
		} catch (Exception e) {
			logger.error("DateUtils.parseCalendarFormat error!", e);
		}
		return cal;
	}

	/**
	 * Calendar to String
	 * 
	 * @param cal
	 *            Calendar
	 * @param partten
	 *            yyyy-MM-dd
	 * @since Jun 13, 2008
	 */
	public static String getDateMilliFormat(Calendar cal, String pattern) {
		return toString(cal.getTime(), pattern);
	}

	/**
	 * get last date of month
	 * 
	 * @param month
	 *            month
	 * @since Jun 13, 2008
	 */
	public static int getLastDayOfMonth(int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear()) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * get last date of year and month
	 * 
	 * @param year
	 *            which year
	 * @param month
	 *            which month
	 * @since Jun 13, 2008
	 */
	public static int getLastDayOfMonth(int year, int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear(year)) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * get last date of date
	 * 
	 * @param date
	 *            date
	 * @since Jun 13, 2008
	 */
	public static Date getLastDayOfMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(2)) {
		case 0: // '\0'
			gc.set(5, 31);
			break;
		case 1: // '\001'
			gc.set(5, 28);
			break;
		case 2: // '\002'
			gc.set(5, 31);
			break;
		case 3: // '\003'
			gc.set(5, 30);
			break;
		case 4: // '\004'
			gc.set(5, 31);
			break;
		case 5: // '\005'
			gc.set(5, 30);
			break;
		case 6: // '\006'
			gc.set(5, 31);
			break;
		case 7: // '\007'
			gc.set(5, 31);
			break;
		case 8: // '\b'
			gc.set(5, 30);
			break;
		case 9: // '\t'
			gc.set(5, 31);
			break;
		case 10: // '\n'
			gc.set(5, 30);
			break;
		case 11: // '\013'
			gc.set(5, 31);
			break;
		}
		if (gc.get(2) == 1 && isLeapYear(gc.get(1))) {
			gc.set(5, 29);
		}
		return gc.getTime();
	}

	/**
	 * get last date of Calender
	 * 
	 * @param date
	 *            Calender
	 * @since Jun 13, 2008
	 */
	public static Calendar getLastDayOfMonth(Calendar gc) {
		switch (gc.get(2)) {
		case 0: // '\0'
			gc.set(5, 31);
			break;
		case 1: // '\001'
			gc.set(5, 28);
			break;
		case 2: // '\002'
			gc.set(5, 31);
			break;
		case 3: // '\003'
			gc.set(5, 30);
			break;
		case 4: // '\004'
			gc.set(5, 31);
			break;
		case 5: // '\005'
			gc.set(5, 30);
			break;
		case 6: // '\006'
			gc.set(5, 31);
			break;
		case 7: // '\007'
			gc.set(5, 31);
			break;
		case 8: // '\b'
			gc.set(5, 30);
			break;
		case 9: // '\t'
			gc.set(5, 31);
			break;
		case 10: // '\n'
			gc.set(5, 30);
			break;
		case 11: // '\013'
			gc.set(5, 31);
			break;
		}
		if (gc.get(2) == 1 && isLeapYear(gc.get(1))) {
			gc.set(5, 29);
		}
		return gc;
	}

	/**
	 * get last date of current week
	 * 
	 * @param date
	 * @since Jun 13, 2008
	 */
	public static Date getLastDayOfWeek(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(7)) {
		case 1: // '\001'
			gc.add(5, 6);
			break;
		case 2: // '\002'
			gc.add(5, 5);
			break;
		case 3: // '\003'
			gc.add(5, 4);
			break;
		case 4: // '\004'
			gc.add(5, 3);
			break;
		case 5: // '\005'
			gc.add(5, 2);
			break;
		case 6: // '\006'
			gc.add(5, 1);
			break;
		case 7: // '\007'
			gc.add(5, 0);
			break;
		}
		return gc.getTime();
	}

	/**
	 * get first date of current week
	 * 
	 * @param date
	 *            date
	 * @since Jun 13, 2008
	 */
	public static Date getFirstDayOfWeek(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(7)) {
		case 1: // '\001'
			gc.add(5, 0);
			break;
		case 2: // '\002'
			gc.add(5, -1);
			break;
		case 3: // '\003'
			gc.add(5, -2);
			break;
		case 4: // '\004'
			gc.add(5, -3);
			break;
		case 5: // '\005'
			gc.add(5, -4);
			break;
		case 6: // '\006'
			gc.add(5, -5);
			break;
		case 7: // '\007'
			gc.add(5, -6);
			break;
		}
		return gc.getTime();
	}

	public static boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		}
		if (year % 4 == 0) {
			return year % 100 != 0;
		} else {
			return false;
		}
	}

	public static boolean isLeapYear(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(1);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(Calendar gc) {
		int year = gc.get(1);
		return isLeapYear(year);
	}

	/**
	 * get current date's year
	 * 
	 * @param date
	 *            Date
	 * @return e.g. return 2011
	 * @since Jun 13, 2008
	 */
	public static int getYear(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(1);
	}

	/**
	 * get current date's month
	 * 
	 * @param date
	 *            Date
	 * @return e.g. return 7
	 * @since Jun 13, 2008
	 */
	public static int getMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(2) + 1;
	}

	/**
	 * get current date's day
	 * 
	 * @param date
	 *            Date
	 * @return e.g. return 7
	 * @since Jun 13, 2008
	 */
	public static int getDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(5);
	}

	/**
	 * get current date's hour
	 * 
	 * @since Jun 13, 2008
	 */
	public static int getHour(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(11);
	}

	/**
	 * get current date's minute
	 * 
	 * @since Jun 13, 2008
	 */
	public static int getMinute(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(12);
	}

	/**
	 * get current date's second
	 * 
	 * @since Jun 13, 2008
	 */
	public static int getSecond(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(13);
	}

	/**
	 * get the given day's next day
	 * 
	 * @param date
	 *            Date
	 * @since Jun 14, 2008
	 */
	public static Date getNextDay(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, 1);
		return gc.getTime();
	}

	/**
	 * get the given day's pre count day
	 * 
	 * @param date
	 *            Date
	 * @param count
	 *            count
	 * @since Jun 14, 2008
	 */
	public static Date getPreData(Date date, int count) {
		Date d = null;
		d = new Date(date.getTime() - count * 24 * 60 * 60 * 1000l);
		return d;
	}

	/**
	 * get the given day's after count day
	 * 
	 * @param date
	 *            Date
	 * @param count
	 *            count
	 * @return
	 */
	public static Date getAfterData(Date date, int count) {
		Date d = null;
		d = new Date(date.getTime() + count * 24 * 60 * 60 * 1000l);
		return d;
	}

	/**
	 * get current month's next month
	 * 
	 * @param date
	 *            Date
	 * @since Jun 14, 2008
	 */
	public static Date getNextMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(2, 1);
		return gc.getTime();
	}

	/**
	 * get current month's next week
	 * 
	 * @param date
	 *            Date
	 * @since Jun 14, 2008
	 */
	public static Date getNextWeek(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, 7);
		return gc.getTime();
	}

	/**
	 * get current month's first day
	 * 
	 * @param date
	 *            Date
	 * @since Jun 14, 2008
	 */
	public static Date getFirstDayOfMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(5, 1);
		return gc.getTime();
	}

	/**
	 * get diff between two dates
	 * 
	 * @param lowerLimitDate
	 *            Date beforeDate
	 * @param upperLimitDate
	 *            Date afterDate
	 * @since Jun 14, 2008
	 */
	public static int getDayInRange(Date lowerLimitDate, Date upperLimitDate) {
		Long result = new Long((upperLimitDate.getTime() - lowerLimitDate.getTime()) / (1000 * 60 * 60 * 24));
		return Math.abs(result.intValue());
	}

	/**
	 * get diff between two dates
	 * 
	 * @param begin
	 *            beginDate
	 * @param end
	 *            endDate
	 */
	public static int getDaysBetween(Calendar begin, Calendar end) {
		if (begin.after(end)) {
			Calendar swap = begin;
			begin = end;
			end = swap;
		}
		int days = end.get(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR);
		int y2 = end.get(Calendar.YEAR);
		if (begin.get(Calendar.YEAR) != y2) {
			begin = (Calendar) begin.clone();
			do {
				days += begin.getActualMaximum(Calendar.DAY_OF_YEAR);
				begin.add(Calendar.YEAR, 1);
			} while (begin.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * <p>
	 * getQuarter
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
	public static int getQuarter(Date date) {
		int d = getMonth(date);
		if (d >= 1 && d <= 3) {
			return 1;
		} else if (d >= 4 && d <= 6) {
			return 2;
		} else if (d >= 7 && d <= 9) {
			return 3;
		} else {
			return 4;
		}
	}

}
