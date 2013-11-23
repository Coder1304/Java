package services;

import hibernate.repositories.UserRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.data.UserData;

import common.EventTypeE;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public void addUser(UserData user) {
		//UserEntitie userEntity = new UserEntitie(user.getName(),user.getSurname(),user.getEvents());
		
	}

	@Override
	@Transactional
	public void addEventToUser(String name, String surname,
			EventTypeE eventType, Date start, Date end) {
		// TODO Auto-generated method stub

	}


}
