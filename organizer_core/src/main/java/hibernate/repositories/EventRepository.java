package hibernate.repositories;

import hibernate.entities.EventEntitie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EventRepository extends JpaRepository<EventEntitie, Integer> {

}
