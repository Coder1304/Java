package hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.entities.Person;

public interface OrganizerRepository extends JpaRepository<Person, Integer> {

}
