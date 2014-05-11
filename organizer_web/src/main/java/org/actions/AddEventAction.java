package org.actions;

import java.util.Date;

import org.ui.AddEventWindow;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class AddEventAction extends BaseAction {
	
	public AddEventAction() {
		super("Add Event");
	}

	@Override
	public void makeAction(Calendar cal, Object target) {
		if (target instanceof Date) {
            Date date = (Date) target;
            AddEventWindow addEventWindow = new AddEventWindow(date, date, cal);
            
            UI.getCurrent().addWindow(addEventWindow);;
        } else{
        	Notification.show("Can't add on an event");
        }
	}

}
