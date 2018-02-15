package br.com.track.management.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Manager {
	public Map<Integer, List<String>> manageEvents(Stream<String> lines) {
		return groupEventsByDuration(lines);
	}

	private Map<Integer, List<String>> groupEventsByDuration(Stream<String> lines) {
		Map<Integer, List<String>> mapEvents = new TreeMap<>(Collections.reverseOrder());

		lines.forEach(line -> {
			int duration = EventUtil.getDurationFromEvent(line);
			if (mapEvents.containsKey(duration)) {
				mapEvents.get(duration).add(line);
			} else {
				List<String> eventList = new ArrayList<>();
				eventList.add(line);
				mapEvents.put(duration, eventList);
			}
		});

		return mapEvents;
	}

	public static Boolean isEmptyMap(Map<Integer, List<String>> mapEvents) {

		Boolean response = true;
		for (Entry<Integer, List<String>> key : mapEvents.entrySet()) {
			if (!key.getValue().isEmpty()) {
				response = false;
				break;
			}
		}

		return response;
	}
}
