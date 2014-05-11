package org.handlers;

import org.actions.AddEventAction;
import org.actions.BaseAction;
import org.actions.DeleteEventAction;
import org.actions.MonthViewAction;

import com.vaadin.event.Action;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.CalendarDateRange;


@SuppressWarnings("serial")
public class ActionHandler implements Action.Handler{

	private static final long serialVersionUID = 1L;
	
     private Action[] actionArray = {new AddEventAction(), new DeleteEventAction(), new MonthViewAction()};
     private Calendar cal;
     
    public ActionHandler(Calendar calendar) {
		this.cal = calendar;
	}


	@Override
	public Action[] getActions(Object target, Object sender) {

        if (! (target instanceof CalendarDateRange) )
            return new Action[0];
        
        return actionArray;
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
        BaseAction tmp = (BaseAction) action;
        tmp.makeAction(cal, target);
	}

}
