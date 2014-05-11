package org.actions;

import org.events.Event;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.components.calendar.event.CalendarEvent;

@SuppressWarnings("serial")
public class DeleteEventAction extends BaseAction {

	public DeleteEventAction() {
		super("Delete Event");
	}

	@Override
	public void makeAction(Calendar cal, Object target) {
		// Check if the action was clicked on top of an event
        if (target instanceof Event) {
            CalendarEvent event = (CalendarEvent) target;
            cal.removeEvent(event);
        } else
        	Notification.show("No event to delete");
	}

}
