package br.com.track.management.builder;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.track.management.model.Event;
import br.com.track.management.model.Session;
import br.com.track.management.model.Track;
import br.com.track.management.rules.Rules;
import br.com.track.management.utils.DateUtil;
import br.com.track.management.utils.EventUtil;

public class TrackManagementBuilder {

	private Track inst;

	private Date timeRemaining;

	private Date timeline;

	public TrackManagementBuilder(String trackName) {
		this.inst = new Track(trackName);
		this.timeline = Rules.getStartHourMorning();
	}

	public TrackManagementBuilder withSessionMorning(Map<Integer, List<String>> lines) {
		this.timeRemaining = DateUtil.createHour(3, 0, Calendar.AM);
		lines.entrySet().forEach(key -> {
			populateSession(key.getValue(), Rules.getLanchHour(), this.inst.getMorning());
		});
		this.inst.getMorning().getEventList()
				.add(new Event(DateUtil.createHour(12, 0, Calendar.AM), "Lunch", 60));
		return this;
	}

	public TrackManagementBuilder withSessionAfternoon(Map<Integer, List<String>> lines) {
		this.timeRemaining = DateUtil.createHour(4, 0, Calendar.AM);
		this.timeline = DateUtil.createHour(1, 0, Calendar.PM);
		lines.entrySet().forEach(key -> {
			populateSession(key.getValue(), Rules.getNetworkMaxHour(), this.inst.getAfternoon());
		});
		this.inst.getAfternoon().getEventList().add(new Event(this.timeline, "Networking Event", 60));
		return this;
	}

	private TrackManagementBuilder populateSession(List<String> lines, Date limit, Session session) {
		Iterator<String> iterator = lines.iterator();
		while (iterator.hasNext()) {
			String eventDescription = iterator.next();
			int durationFromEvent = EventUtil.getDurationFromEvent(eventDescription);
			Date durationTimeEvent = DateUtil.createHour(durationFromEvent);
			if (this.timeline.before(limit) && (durationTimeEvent.before(timeRemaining) || durationTimeEvent.equals(timeRemaining))) {
				session.getEventList().add(new Event(this.timeline, eventDescription, durationFromEvent));
				this.timeRemaining = DateUtil.reduceMinutesFromHour(this.timeRemaining, durationFromEvent);
				this.timeline = DateUtil.addMinutesFromHour(this.timeline, durationFromEvent);
				iterator.remove();
			}
		}
		return this;
	}

	public Track construct() {
		return inst;
	}

}
