package services.data;

import java.util.Date;

import common.EventTypeE;

public class EventData {

	Date eventStart;	
	Date eventStop;
	EventTypeE eventType;	
	UserData user;

	public Date getEventStart() {
		return eventStart;
	}

	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}

	public Date getEventStop() {
		return eventStop;
	}

	public void setEventStop(Date eventStop) {
		this.eventStop = eventStop;
	}

	public EventTypeE getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeE eventType) {
		this.eventType = eventType;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}	
	
	public EventData() {
		super();
	}
	
	public EventData(EventTypeE type, Date start, Date stop, UserData user){
		this.eventType 		= type; 
		this.eventStart 	= start;
		this.eventStop 		= stop;
		this.user 			= user;
	}
}
