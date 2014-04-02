package org.actions;

import java.util.Date;

import org.common.DateProvider;

import com.vaadin.event.Action;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.components.calendar.event.BasicEvent;

@SuppressWarnings("serial")
public class AddEventAction extends BaseAction {
	
	public AddEventAction() {
		super("Add Event");
	}

	@Override
	public void makeAction(Calendar cal, Object target) {
		if (target instanceof Date) {
            Date date = (Date) target;
            
            cal.addEvent(new BasicEvent("Calendar study",
                    "Learning how to use Vaadin Calendar",
                    date, DateProvider.getDateHoursLater(date, 1)));
        } else
        	Notification.show("Can't add on an event");
	}

}
