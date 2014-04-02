package org.events;

import java.util.Date;

import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent.EventChangeNotifier;
import com.vaadin.ui.components.calendar.event.EditableCalendarEvent;

@SuppressWarnings("serial")
public class Event  implements CalendarEvent, EventChangeNotifier, EditableCalendarEvent{
	
	private Date start;
	private Date end;
	private Integer id = null;
	private String caption = "none";
	private String description = "none";
	private Boolean allDay = false;
	
	EventChangeListener listener = null;
	
	public Event(Date start, Date end,Integer id, String caption, String description,
			Boolean allDay) {
		super();
		this.start = start;
		this.end = end;
		this.id = id;
		this.caption = caption;
		this.description = description;
		this.allDay = allDay;
	}	

	public Event(CalendarEvent event) {
		super();
		this.start = event.getStart();
		this.end = event.getEnd();
		this.caption = event.getCaption();
		this.description = event.getDescription();
		this.allDay = event.isAllDay();
	}	

	
	@Override
	public void addEventChangeListener(EventChangeListener listener) {
		this.listener = listener;
	}

	@Override
	public void removeEventChangeListener(EventChangeListener listener) {
		this.listener = null;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Date getStart() {
		// TODO Auto-generated method stub
		return start;
	}

	public void setStart(Date start) {
		if (listener != null) listener.eventChange(new EventChangeEvent(this));
		this.start = start;
	}

	@Override
	public Date getEnd() {
		// TODO Auto-generated method stub
		return end;
	}

	public void setEnd(Date end) {
		if (listener != null) listener.eventChange(new EventChangeEvent(this));
		this.end = end;
	}

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return caption;
	}

	public void setCaption(String caption) {
		if (listener != null) listener.eventChange(new EventChangeEvent(this));
		this.caption = caption;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public void setDescription(String description) {
		if (listener != null) listener.eventChange(new EventChangeEvent(this));
		this.description = description;
	}

	@Override
	public String getStyleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAllDay() {
		// TODO Auto-generated method stub
		return allDay;
	}

	public void setAllDay(Boolean allDay) {
		if (listener != null) listener.eventChange(new EventChangeEvent(this));
		this.allDay = allDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allDay == null) ? 0 : allDay.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (allDay == null) {
			if (other.allDay != null)
				return false;
		} else if (!allDay.equals(other.allDay))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public void setStyleName(String styleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllDay(boolean isAllDay) {
		// TODO Auto-generated method stub
		
	}

	

}
