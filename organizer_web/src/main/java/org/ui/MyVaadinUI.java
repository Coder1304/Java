package org.ui;

import java.util.Date;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import org.common.DateProvider;
import org.events.EventProvider;
import org.handlers.ActionHandler;
import org.handlers.DateClickHandler;

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
		EventProvider.getInstance().setSaveButton(button);
		toolBar.addComponent(button);

		Calendar cal = new Calendar("Organizer Calendar");
		cal.setWidth("100%");
		cal.setHeight("600px");
		cal.setLocale(new Locale("pl", "PL"));
		cal.setFirstVisibleHourOfDay(0);
		cal.setLastVisibleHourOfDay(23);
		cal.setFirstVisibleDayOfWeek(1);
		cal.setLastVisibleDayOfWeek(7);
		Date date = new Date();
		System.out.println(date);
		Date tmpDate = DateProvider.getFirstDayOfWeek(date);
		System.out.println("Start Date: "+tmpDate);
		cal.setStartDate(DateProvider.getFirstDayOfWeek(date));
		
		tmpDate = DateProvider.getLastDayOfWeek(new Date());
		System.out.println("End Date: "+tmpDate);
		cal.setEndDate(DateProvider.getLastDayOfWeek(new Date()));
		cal.setEventProvider(EventProvider.getInstance());

		cal.setHandler(new DateClickHandler());
		cal.addActionHandler(new ActionHandler(cal));
		
		layout.addComponent(cal);

		/*
		 * button.addClickListener(new Button.ClickListener() { public void
		 * buttonClick(ClickEvent event) {
		 * event.getButton().getUI().addComponent(new
		 * Label("Thank you for clicking")); } });
		 */

	}
}
