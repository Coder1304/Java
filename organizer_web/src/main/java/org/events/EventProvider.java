package org.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.common.DateProvider;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEditableEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent.EventChangeEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent.EventChangeListener;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

@SuppressWarnings("serial")
public class EventProvider implements CalendarEventProvider, ClickListener,
		EventChangeListener, CalendarEditableEventProvider {

	private static EventProvider instance = null;
	private Button saveButton;

	private List<CalendarEvent> notsavedEvents = new ArrayList<CalendarEvent>();
	private List<CalendarEvent> removedEvents = new ArrayList<CalendarEvent>();
	private HashMap<Integer, CalendarEvent> savedEvents = new HashMap<Integer, CalendarEvent>();;

	class EventComparator implements Comparator<CalendarEvent> {
		public int compare(CalendarEvent event1, CalendarEvent event2) {
			return event1.getStart().compareTo(event2.getStart());
		}
	}

	private EventProvider() {
		super();
		Event event = new Event(new Date(),DateProvider.getDateHoursLater(new Date(), 5),1,"My event","My event description",false);
		event.addEventChangeListener(this);
		savedEvents.put(1,  event);
	}

	public static EventProvider getInstance() {
		if (instance == null) {
			instance = new EventProvider();
		}
		return instance;
	}

	@Override
	public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
		for (CalendarEvent i : notsavedEvents) {
			Event j = (Event) i;
			if (j.getId() != null) {
				savedEvents.remove(j.getId());
			}
		}
		List<CalendarEvent> allEvents = new ArrayList<CalendarEvent>(
				savedEvents.values());
		allEvents.addAll(notsavedEvents);
		Collections.sort(allEvents, new EventComparator());

		return (List<CalendarEvent>) allEvents;
	}


	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		saveButton.setEnabled(false);

		Notification.show("Changes Saved");
	}

	@Override
	public void eventChange(EventChangeEvent eventChangeEvent) {
		// TODO Auto-generated method stub
		saveButton.setEnabled(true);
		saveButton.setDisableOnClick(true);

	}

	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
		this.saveButton.addClickListener(this);
	}

	@Override
	public void addEvent(CalendarEvent event) {
		Event tmp = new Event(event);
		tmp.addEventChangeListener(this);
		notsavedEvents.add(tmp);
		saveButton.setEnabled(true);
	}
	
	@Override
	public void removeEvent(CalendarEvent event) {
		Event tmp = (Event) event;
		
		if (tmp.getId() == null){
			notsavedEvents.remove((Event)event);
		}else{
			removedEvents.add(tmp);
			savedEvents.remove(tmp.getId());
		}
	}
}
