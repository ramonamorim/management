package br.com.track.management.util;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.track.management.utils.EventUtil;

public class EventUtilTest {

	@Test
	public void getDurationFromEventTest() {
		assertEquals(30, EventUtil.getDurationFromEvent("EventTest 30min"));
	}
}
