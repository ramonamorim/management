package br.com.track.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Session {

	private Date startTime;

	private Date endTime;

	private List<Event> eventList = new ArrayList<>();

	public Session(Date startTime, Date endTime) {
		this.setEndTime(endTime);
		this.setStartTime(startTime);
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

}
