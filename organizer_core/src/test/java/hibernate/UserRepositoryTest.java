package hibernate;

import static org.fest.assertions.Assertions.assertThat;
import hibernate.entities.EventEntitie;
import hibernate.entities.UserEntitie;
import hibernate.repositories.UserRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import common.EventTypeE;

import configuration.TestConfigurationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfigurationContext.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Test
	public void InsertUser() {

		UserEntitie user = new UserEntitie("Szymon", "Stefan");

		userRepository.save(user);

		UserEntitie dbpost = userRepository.findOne(user.getUserId());
		assertThat(dbpost).isNotNull();
	}

	@Test
	public void InsertUserWithEvent() {
		UserEntitie user = new UserEntitie("Hakuna", "Matata");

		Set<EventEntitie> events = new HashSet<EventEntitie>();
		events.add(new EventEntitie(EventTypeE.bear, new Date(), new Date(),
				user));

		user.setEvents(events);

		userRepository.save(user);

		UserEntitie dbpost = userRepository.findOne(user.getUserId());

		assertThat(dbpost).isNotNull();
		assertThat(dbpost.getEvents()).isNotNull().hasSize(1);
	}

	@Test
	public void FindUserByName() {

		UserEntitie user = new UserEntitie("Flip", "Flap");
		user.setEvents(new HashSet<EventEntitie>());

		userRepository.save(user);

		List<UserEntitie> dbpost = userRepository
				.findUserByName(user.getName());
		assertThat(dbpost).isNotNull().isNotEmpty().hasSize(1)
				.containsOnly(user);
		System.out.println(dbpost.get(0).toString());
	}

	@Test
	public void FindUserBySurname() {

		UserEntitie user1 = new UserEntitie("Filippa", "Eilhart");
		user1.setEvents(new HashSet<EventEntitie>());
		UserEntitie user2 = new UserEntitie("Bogdan", "Eilhart");
		user2.setEvents(new HashSet<EventEntitie>());

		userRepository.save(user1);
		userRepository.save(user2);

		List<UserEntitie> dbpost = userRepository.findUserBySurname("Eilhart");
		assertThat(dbpost).isNotNull().hasSize(2).contains(user1)
				.contains(user2);
	}
}
