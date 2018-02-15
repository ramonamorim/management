package br.com.track.management.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.track.management.utils.DateUtil;



public class DateUtilTest {

	@Test
	public void createHour1Test() {
		Calendar calendar = getCalendar();

		Date expected = calendar.getTime();

		Date actual = DateUtil.createHour(1, 5, Calendar.AM);

		assertEquals(expected, actual);
	}

	@Test
	public void createHour2Test() {
		Calendar calendar = getCalendar();

		Date expected = calendar.getTime();

		Date actual = DateUtil.createHour(65);

		assertEquals(expected, actual);
	}

	@Test
	public void reduceMinutesFromHourTest() {

		Calendar calendar = getCalendar();
		calendar.set(Calendar.MINUTE, 0);

		Date expected = calendar.getTime();

		calendar.set(Calendar.MINUTE, 5);
		Date actual = DateUtil.reduceMinutesFromHour(calendar.getTime(), 5);

		assertEquals(expected, actual);
	}

	@Test
	public void AddMinutesFromHourTest() {

		Calendar calendar = getCalendar();
		calendar.set(Calendar.MINUTE, 20);

		Date expected = calendar.getTime();

		calendar.set(Calendar.MINUTE, 5);
		Date actual = DateUtil.addMinutesFromHour(calendar.getTime(), 15);

		assertEquals(expected, actual);
	}

	private Calendar getCalendar() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 1);
		calendar.set(Calendar.MINUTE, 5);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar;
	}

}
