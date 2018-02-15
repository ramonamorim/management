package br.com.track.management.model;

import br.com.track.management.rules.Rules;

public class Track {

	private Session morning;
	private Session afternoon;

	private String trackName;

	public Track(String trackName) {
		this.trackName = trackName;
		this.morning = new Session(Rules.getStartHourMorning(), Rules.getLanchHour());
		this.afternoon = new Session(Rules.getStartHourAfternoon(), null);
	}

	public Track() {

	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(this.trackName + "\n");
		if (this.getMorning() != null && !this.getMorning().getEventList().isEmpty()) {
			this.getMorning().getEventList().forEach(event -> {
				text.append(event.toString() + "\n");
			});
		}

		if (this.getAfternoon() != null && !this.getAfternoon().getEventList().isEmpty()) {
			this.getAfternoon().getEventList().forEach(event -> {
				text.append(event.toString() + "\n");
			});
		}

		return text.toString();
	}

	public Session getMorning() {
		return morning;
	}

	public void setMorning(Session morning) {
		this.morning = morning;
	}

	public Session getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(Session afternoon) {
		this.afternoon = afternoon;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
}
