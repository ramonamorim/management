package br.com.track.management.rules;

import java.util.Calendar;
import java.util.Date;

import br.com.track.management.utils.DateUtil;

public class Rules {
	public static Date getStartHourMorning() {
		return DateUtil.createHour(9, 0, Calendar.AM);
	}

	public static Date getStartHourAfternoon() {
		return DateUtil.createHour(1, 0, Calendar.PM);
	}

	public static Date getLanchHour() {
		return DateUtil.createHour(12, 0, Calendar.AM);
	}

	public static Date getNetworkMinHour() {
		return DateUtil.createHour(4, 0, Calendar.PM);
	}

	public static Date getNetworkMaxHour() {
		return DateUtil.createHour(5, 0, Calendar.PM);
	}

}
