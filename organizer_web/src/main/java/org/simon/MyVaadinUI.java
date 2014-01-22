package org.simon;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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

	@Override
	protected void init(VaadinRequest request) {
		
		Notification.show("Start to print web");

		Label head = new Label("zaczynam ladowac stronke");
		
		layout.addComponent(head);
		
		layout.setSizeFull();
		
		Calendar cal = new Calendar("My Calendar");
		cal.setWidth("600px");
		cal.setHeight("300px");
		cal.setStartDate(new Date());
		cal.setEndDate(new Date());

		layout.addComponent(cal);

		Button button = new Button("Click Me");
		/*
		 * button.addClickListener(new Button.ClickListener() { public void
		 * buttonClick(ClickEvent event) {
		 * event.getButton().getUI().addComponent(new
		 * Label("Thank you for clicking")); } });
		 */
		layout.addComponent(button);
		Notification.show("Stop doing that :)");

		setContent(layout);
		
	}

}
