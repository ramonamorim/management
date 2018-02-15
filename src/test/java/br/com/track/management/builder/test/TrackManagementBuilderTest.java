package br.com.track.management.builder.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import br.com.track.management.builder.TrackManagementBuilder;
import br.com.track.management.utils.FileReader;
import br.com.track.management.utils.Manager;

public class TrackManagementBuilderTest {
	@Test
	public void constructTest() {

		StringBuilder output = new StringBuilder();

		Stream<String> lines = new FileReader().readFile("input.txt");

		int count = 1;
		Map<Integer, List<String>> manageEvents = new Manager().manageEvents(lines);
		do {
			output.append(new TrackManagementBuilder((String.format("Track %s:", count))).withSessionMorning(manageEvents)
					.withSessionAfternoon(manageEvents).construct().toString());
			count++;
		} while (!Manager.isEmptyMap(manageEvents));

		System.out.println(output.toString());
		assertEquals(getOutputExpected().toString(), output.toString());
	}

	private StringBuilder getOutputExpected() {
		StringBuilder outputExpected = new StringBuilder();
		outputExpected.append("Track 1:\n");
		outputExpected.append("09:00 AM - ﻿Writing Fast Tests Against Enterprise Rails 60min\n");
		outputExpected.append("10:00 AM - Communicating Over Distance 60min\n");
		outputExpected.append("11:00 AM - Rails Magic 60min\n");
		outputExpected.append("12:00 PM - Lunch\n");
		outputExpected.append("01:00 PM - Ruby on Rails: Why We Should Move On 60min\n");
		outputExpected.append("02:00 PM - Ruby on Rails Legacy App Maintenance 60min\n");
		outputExpected.append("03:00 PM - Overdoing it in Python 45min\n");
		outputExpected.append("03:45 PM - Ruby Errors from Mismatched Gem Versions 45min\n");
		outputExpected.append("04:30 PM - Lua for the Masses 30min\n");
		outputExpected.append("05:00 PM - Networking Event\n");
		outputExpected.append("Track 2:\n");
		outputExpected.append("09:00 AM - Common Ruby Errors 45min\n");
		outputExpected.append("09:45 AM - Accounting-Driven Development 45min\n");
		outputExpected.append("10:30 AM - Pair Programming vs Noise 45min\n");
		outputExpected.append("11:15 AM - Clojure Ate Scala (on my project) 45min\n");
		outputExpected.append("12:00 PM - Lunch\n");
		outputExpected.append("01:00 PM - Woah 30min\n");
		outputExpected.append("01:30 PM - Sit Down and Write 30min\n");
		outputExpected.append("02:00 PM - Programming in the Boondocks of Seattle 30min\n");
		outputExpected.append("02:30 PM - Ruby vs. Clojure for Back-End Development 30min\n");
		outputExpected.append("03:00 PM - A World Without HackerNews 30min\n");
		outputExpected.append("03:30 PM - User Interface CSS in Rails Apps 30min\n");
		outputExpected.append("04:00 PM - Rails for Python Developers lightning 05min\n");
		outputExpected.append("04:05 PM - Networking Event\n");
		return outputExpected;
	}
}
