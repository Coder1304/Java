package hibernate.repositories;

import hibernate.entities.UserEntitie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserEntitie, Integer> {
	
}
