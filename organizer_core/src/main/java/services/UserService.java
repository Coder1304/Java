package services;

import java.util.Date;

import services.data.UserData;

import common.EventTypeE;

public interface UserService {
	
	void addUser(UserData user);
	void addEventToUser(String name, String surname, EventTypeE eventType, Date start, Date end);
}
