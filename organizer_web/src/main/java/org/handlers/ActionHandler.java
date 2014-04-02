package org.handlers;

import java.util.ArrayList;
import java.util.List;

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
	
     List<Action> actionList ;
     private Calendar cal;
     
    public ActionHandler(Calendar calendar) {
		this.cal = calendar;
		actionList = new ArrayList<Action>();
	}


	@Override
	public Action[] getActions(Object target, Object sender) {

        if (! (target instanceof CalendarDateRange) )
            return new Action[0];
        
        actionList.clear();
        actionList.add(new AddEventAction());
        actionList.add(new DeleteEventAction());
        actionList.add(new MonthViewAction());
        
        System.out.println("Size of List array: "+actionList.size());
        
        Action [] tmp = actionList.toArray(new Action[0]);
        
        System.out.println("Size of out array: "+tmp.length);
        
        AddEventAction add = new AddEventAction();
        
        Action[] tmp2 = { new AddEventAction(), new DeleteEventAction(), new MonthViewAction()};
        
        return tmp2;
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
        BaseAction tmp = (BaseAction) action;
        tmp.makeAction(cal, target);
	}

}
