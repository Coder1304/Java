package org.actions;

import java.util.Date;

import org.common.DateProvider;

import com.vaadin.ui.Calendar;

@SuppressWarnings("serial")
public class MonthViewAction extends BaseAction {

	public MonthViewAction() {
		super("Month View");
	}

	@Override
	public void makeAction(Calendar cal, Object target) {
		if (target instanceof Date) {
    		Date date = (Date) target;
    		cal.setStartDate(DateProvider.getFirstDayOfMonth(date));
			cal.setEndDate(DateProvider.getLastDayOfMonth(date));
    	}
	}

}
