package br.com.track.management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventUtil {
	private static final String DURATION = "([0-9])\\w+";

	private static final String DURATION_TIME = "([0-9])\\w";

	private static Matcher matcher;

	public static int getDurationFromEvent(String eventDescription) {
		int duration = 0;
		matcher = Pattern.compile(DURATION).matcher(eventDescription);
		if (matcher.find()) {
			String durationText = matcher.group();
			matcher = Pattern.compile(DURATION_TIME).matcher(durationText);
			if (matcher.find()) {
				duration = Integer.parseInt(matcher.group());
			}
		}

		return duration;
	}
}
