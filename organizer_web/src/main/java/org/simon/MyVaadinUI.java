package org.simon;

import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.layout.client.Layout.Alignment;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {
	
	@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "org.simon.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	VerticalLayout layout = new VerticalLayout();
	HorizontalLayout toolBar = new HorizontalLayout();

	@Override
	protected void init(VaadinRequest request) {
		
		setContent(layout);
		layout.setDefaultComponentAlignment(com.vaadin.ui.Alignment.TOP_LEFT);
		layout.setSpacing(false);
		toolBar.setSpacing(false);
		
		layout.addComponent(toolBar);

		Button button = new Button("Save changes");
		button.setEnabled(false);
		toolBar.addComponent(button);
		
		GregorianCalendar dateProvider = new GregorianCalendar();
		dateProvider.setFirstDayOfWeek(java.util.Calendar.MONDAY);
		
		Calendar cal = new Calendar("Organizer Calendar");
		cal.setWidth("100%");
		cal.setHeight("600px");
		cal.setLocale(new Locale("pl", "PL"));
		cal.setFirstVisibleHourOfDay(0);
		cal.setLastVisibleHourOfDay(23);
		cal.setFirstVisibleDayOfWeek(1);
		cal.setLastVisibleDayOfWeek(7);
		dateProvider.set(java.util.Calendar.DAY_OF_WEEK,java.util.Calendar.MONDAY);
		cal.setStartDate(dateProvider.getTime()) ;
		dateProvider.set(java.util.Calendar.DAY_OF_WEEK,java.util.Calendar.SUNDAY);
		cal.setEndDate(dateProvider.getTime());

		layout.addComponent(cal);

		/*
		 * button.addClickListener(new Button.ClickListener() { public void
		 * buttonClick(ClickEvent event) {
		 * event.getButton().getUI().addComponent(new
		 * Label("Thank you for clicking")); } });
		 */

		
	}

}
