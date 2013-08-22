package hibernate;

import static org.junit.Assert.assertNotNull;
import hibernate.entities.Person;
import hibernate.entities.UserEvent;
import hibernate.repositories.OrganizerRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.EventTypeE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class OrganizerRepositoryTest {

	@Autowired
	OrganizerRepository repository;
	
	@Test
	public void InsertUser() {
		
		Person user = new Person();
		user.setName("Szymon");
		user.setSurname("Stefan");
		
		repository.save(user);
		
		Person dbpost = repository.findOne(user.getUserId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getUserId()+" "+dbpost.getName()+" "+dbpost.getSurname());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void InsertUserEvent() {
		Person user = new Person();
		user.setName("Hakuna");
		user.setSurname("Matata");
		
		Set<UserEvent> events = new HashSet<UserEvent>();
		UserEvent event = new UserEvent();
		event.setEventStart(new Date());
		event.setEventStop(new Date());
		event.setEventType(EventTypeE.bear);
		event.setUser(user);
		
		events.add(event);
		
		user.setEvents(events);
		
		repository.save(user);
		
		Person dbpost = repository.findOne(user.getUserId());
		assertNotNull(dbpost);
		assertNotNull(dbpost.getEvents());
		Assert.assertEquals(1, dbpost.getEvents().size());
		System.out.println(dbpost.getUserId()+" "+dbpost.getName()+" "+dbpost.getSurname());
	}

}
