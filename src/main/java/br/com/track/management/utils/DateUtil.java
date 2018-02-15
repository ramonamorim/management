package br.com.track.management.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date createHour(int minutes) {

		int hour = minutes / 60;
		int minute = minutes % 60;

		return createHour(hour, minute, Calendar.AM);
	}

	public static Date reduceMinutesFromHour(Date hour, int minutes) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hour);
		calendar.add(Calendar.MINUTE, minutes * -1);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date addMinutesFromHour(Date hour, int minutes) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hour);
		calendar.add(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date createHour(int hour, int minute, int amPm) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.AM_PM, amPm);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}
