package br.com.track.management.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import br.com.track.management.utils.FileReader;
import br.com.track.management.utils.Manager;

public class ManagerTest {

	private Map<Integer, List<String>> eventsMap;

	@Before
	public void init() {
		Stream<String> lines = new FileReader().readFile("input.txt");
		Manager manager = new Manager();
		eventsMap = manager.manageEvents(lines);
	}

	@Test
	public void manageEventsCount60minTest() {
		assertEquals(5, this.eventsMap.get(60).size());
	}

	@Test
	public void manageEventsCount45minTest() {
		assertEquals(6, this.eventsMap.get(45).size());
	}

	@Test
	public void manageEventsCount30minTest() {
		assertEquals(7, this.eventsMap.get(30).size());
	}

	@Test
	public void manageEventsCount5minTest() {
		assertEquals(1, this.eventsMap.get(5).size());
	}

	@Test
	public void isEmptyMapTest() {
		Map<Integer, List<String>> mapEmpty = new HashMap<>();
		assertEquals(true, (Manager.isEmptyMap(mapEmpty)));
	}

	@Test
	public void isNotEmptyMapTest() {
		assertEquals(false, (Manager.isEmptyMap(eventsMap)));
	}
}
