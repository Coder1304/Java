package hibernate;

import static org.fest.assertions.Assertions.assertThat;
import hibernate.entities.EventEntitie;
import hibernate.entities.UserEntitie;
import hibernate.repositories.EventRepository;
import hibernate.repositories.UserRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.EventTypeE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Test
	public void InsertUser() {
		
		UserEntitie user = new UserEntitie();
		user.setName("Szymon");
		user.setSurname("Stefan");
		
		userRepository.save(user);
		
		UserEntitie dbpost = userRepository.findOne(user.getUserId());
		assertThat(dbpost).isNotNull();
	}
	

	@Test
	public void InsertUserEvent() {
		UserEntitie user = new UserEntitie();
		user.setName("Hakuna");
		user.setSurname("Matata");
		
		Set<EventEntitie> events = new HashSet<EventEntitie>();
		EventEntitie event = new EventEntitie();
		event.setEventStart(new Date());
		event.setEventStop(new Date());
		event.setEventType(EventTypeE.bear);
		event.setUser(user);
		
		events.add(event);
		
		user.setEvents(events);
		
		userRepository.save(user);
		
		UserEntitie dbpost = userRepository.findOne(user.getUserId());
		
		assertThat(dbpost).isNotNull();
		assertThat(dbpost.getEvents()).isNotNull().hasSize(1);
	}

}
