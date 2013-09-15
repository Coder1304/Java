package hibernate.repositories;

import hibernate.entities.UserEntitie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserEntitie, Integer> {
	
	@Query("SELECT u FROM UserEntitie u WHERE u.name = ?1")  
    public List<UserEntitie> findUserByName(String name);
	
	@Query("SELECT u FROM UserEntitie u WHERE u.surname = ?1")  
    public List<UserEntitie> findUserBySurname(String surname);
}
