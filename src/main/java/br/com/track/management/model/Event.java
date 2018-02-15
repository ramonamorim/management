package br.com.track.management.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

	private static final String HR_FORMAT = "hh:mm a";

	private Date schedule;
	private String description;
	private int duration;

	public Event(Date schedule, String description, int duration) {
		this.schedule = schedule;
		this.description = description;
		this.duration = duration;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;

	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", new SimpleDateFormat(HR_FORMAT).format(this.schedule), this.description);
	}

}
