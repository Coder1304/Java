package org.actions;

import com.vaadin.event.Action;
import com.vaadin.ui.Calendar;

@SuppressWarnings("serial")
public abstract class BaseAction extends Action {
	
	public BaseAction(String caption) {
		super(caption);
	}

	public abstract void makeAction(Calendar cal, Object target);
}
