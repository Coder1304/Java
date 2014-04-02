package org.handlers;

import org.common.DateProvider;

import com.vaadin.shared.ui.calendar.DateConstants;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickEvent;
import com.vaadin.ui.components.calendar.handler.BasicDateClickHandler;

@SuppressWarnings("serial")
public class DateClickHandler extends BasicDateClickHandler {

	public void dateClick(DateClickEvent event) {
		Calendar cal = event.getComponent();
		long currentCalDateRange = cal.getEndDate().getTime()
				- cal.getStartDate().getTime();

		if (currentCalDateRange < DateConstants.DAYINMILLIS) {
			cal.setStartDate(DateProvider.getFirstDayOfWeek(event.getDate()));
			cal.setEndDate(DateProvider.getLastDayOfWeek(event.getDate()));
		} else {
			super.dateClick(event);
		}
	}
}
