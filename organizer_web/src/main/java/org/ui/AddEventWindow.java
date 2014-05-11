package org.ui;


import java.util.Date;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AddEventWindow extends Window {
	
	private DateField startDate  = new DateField();
	private DateField endDate  = new DateField();
	private TextField captionText;
	private TextArea descriptionText;
	private CheckBox allDay;
	private Calendar cal;

	public AddEventWindow(Date eventStart, Date eventEnd, Calendar cal) {
		// TODO Auto-generated constructor stub
		super("Add Event");
		setModal(true);
		setClosable(false);
		this.cal = cal;
		
		setWidth("50%");
		setHeight("50%");
		
		addComponents(eventStart,eventEnd);
		
		center();
	}

	private void addComponents(Date eventStart, Date eventEnd) {
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		setContent(content);
		
		allDay = new CheckBox("Is all day event", false);
		allDay.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if ((boolean) event.getProperty().getValue()){
					startDate.setDateFormat("yyyy-MM-dd");
					endDate.setDateFormat("yyyy-MM-dd");
				}else {
					startDate.setDateFormat("yyyy-MM-dd HH:mm");
					endDate.setDateFormat("yyyy-MM-dd HH:mm");
					startDate.setValue(startDate.getValue());
					endDate.setValue(endDate.getValue());
				}
			}
		});;
		
		content.addComponent(allDay);

		GridLayout dateLayout = new GridLayout(2,2);
		
		dateLayout.addComponent(new Label("From:"),0,0);
		startDate.setDateFormat("yyyy-MM-dd HH:mm");
		startDate.setValue(eventStart);
		startDate.setWidth("100%");
		dateLayout.addComponent(startDate,1,0);
		dateLayout.setComponentAlignment(startDate,Alignment.MIDDLE_LEFT);
		
		dateLayout.addComponent(new Label("To:"),0,1);
		endDate.setDateFormat("yyyy-MM-dd HH:mm");
		endDate.setWidth("100%");
		endDate.setValue(eventEnd);		
		dateLayout.addComponent(endDate,1,1);
		dateLayout.setComponentAlignment(endDate,Alignment.MIDDLE_LEFT);
		
		dateLayout.setWidth("100%");
		
		content.addComponent(dateLayout);

		content.addComponent(new Label("Caption:"));
		captionText = new TextField();
		captionText.setValue("Event name");
		captionText.setWidth("100%");
		content.addComponent(captionText);
		
		content.addComponent(new Label("Description:"));
		descriptionText = new TextArea();
		descriptionText.setWordwrap(true);
		descriptionText.setValue("What you plan?");
		descriptionText.setWidth("100%");
		descriptionText.setHeight("100%");
		content.addComponent(descriptionText);
		
		
		HorizontalLayout buttonsLayout = new HorizontalLayout();
		Button cancelButton = new Button("Cancel");
		cancelButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				close();				
			}
		});
		buttonsLayout.addComponent(cancelButton);
		
		Button saveEventButton = new Button("Save Event");
		saveEventButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				org.events.Event calendarEvent = new org.events.Event(startDate.getValue(),endDate.getValue(),null,captionText.getValue(),descriptionText.getValue(),allDay.getValue());
				cal.addEvent(calendarEvent);
				
				close();				
			}
		});
		buttonsLayout.addComponent(saveEventButton);
		buttonsLayout.setComponentAlignment(saveEventButton, Alignment.BOTTOM_RIGHT);
		buttonsLayout.setWidth("100%");
		
		content.addComponent(buttonsLayout);
		
	}

}
