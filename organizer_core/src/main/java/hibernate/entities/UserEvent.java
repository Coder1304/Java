package hibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import common.EventTypeE;

@Entity
@Table(name="Events")
public class UserEvent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EVENT_ID",nullable=false)
	Integer eventId;
	
	@Column(name="EVENT_START")
	Date eventStart;
	
	@Column(name="EVENT_STOP")
	Date eventStop;
	
	@Column(name="EVENT_TYPE")
	EventTypeE eventType;
		
	@ManyToOne
    @JoinColumn(name="USER_ID", 
            insertable=false, updatable=false, 
            nullable=false)
	Person user;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

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

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}	
}
