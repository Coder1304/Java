package hibernate.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID",nullable=false)
	Integer userId;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="SURNAME")
	String surname;
	
//	@OneToMany
//    @JoinColumn(name="users")
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
	private Set<UserEvent> events;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<UserEvent> getEvents() {
		return events;
	}

	public void setEvents(Set<UserEvent> events) {
		this.events = events;
	}
}
