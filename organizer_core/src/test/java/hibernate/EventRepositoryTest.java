package hibernate;

import static org.fest.assertions.Assertions.assertThat;
import hibernate.entities.EventEntitie;
import hibernate.entities.UserEntitie;
import hibernate.repositories.EventRepository;
import hibernate.repositories.UserRepository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import common.EventTypeE;

import configuration.AppConfigurationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
						classes=AppConfigurationContext.class)
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class EventRepositoryTest {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public EventRepository getEventRepository() {
		return eventRepository;
	}
	
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Test
	public void InsertEvent() {
		UserEntitie user = new UserEntitie("Szymon", "Stefan");
		EventEntitie event = new EventEntitie(EventTypeE.bear, new Date(), new Date(),user);
		
		userRepository.save(user);
		eventRepository.save(event);
		
	}


}
